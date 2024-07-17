package com.ple.investmentGame;

import java.util.Scanner;

public class PromptService {
  
  public static PromptService make() {
    return new PromptService();
  }

  public void play() {
    userStatsInit();
    invest();
  }

  public void userStatsInit() {
    System.out.println("Separate the following with spaces to generate deck:");
    System.out.println("Total cards; Winning cards; Growth factor; Token goal");
    Scanner scanner = new Scanner(System.in);
    String deckInputsAsStrings = scanner.nextLine();
    String[] deckInputsAsArrayOfStrings = deckInputsAsStrings.split(" ");
    int numberOfCards = Integer.parseInt(deckInputsAsArrayOfStrings[0]);
    int numberOfWins = Integer.parseInt(deckInputsAsArrayOfStrings[1]);
    int growthFactor = Integer.parseInt(deckInputsAsArrayOfStrings[2]);
    int tokenGoal = Integer.parseInt(deckInputsAsArrayOfStrings[3]);
    Deck deck = Deck.generate(numberOfCards, numberOfWins);
    deck.shuffle();
    deck.putGrowthFactor(growthFactor);
    InvestmentGameModelService igms = ServiceHolder.investmentGameModelService;
    igms.putDeck(deck);
    igms.putTokenGoal(tokenGoal);
    System.out.println("Enter your number of starting tokens:");
    int startingTokens = scanner.nextInt();
    igms.putTokens(startingTokens);
    confirmationMessage();
  }

  private void confirmationMessage() {
    InvestmentGameModelService igms = ServiceHolder.investmentGameModelService;
    Deck deck = igms.getDeck();
    int numberOfWins = deck.calcWinsRemaining();
    int numberOfCards = deck.length();
    int growthFactor = deck.getGrowthFactor();
    int tokens = igms.getTokens();
    System.out.println("Your deck has " + numberOfWins + " wins and " + numberOfCards + " total cards, " +
      "with a growth factor of " + growthFactor + ". You have " + tokens + " tokens to start with.");
    System.out.println();
  }

  public void invest() {
    InvestmentGameModelService igms = ServiceHolder.investmentGameModelService;
    Deck deck = igms.getDeck();
    boolean keepGoing = deck.length() > 0;
    while(keepGoing) {
      int cardsRemaining = deck.length();
      int winsRemaining = deck.calcWinsRemaining();
      int tokens = igms.getTokens();
      int tokenGoal = igms.getTokenGoal();
      int growthFactor = deck.getGrowthFactor();
      turnlyStatReport(tokens, tokenGoal, deck, growthFactor);
      int investment = userInvestmentPromptAndGetInvestment(tokens);
      keepGoing = chancesOfWinningOrLosingInevitable(cardsRemaining, winsRemaining);
      if(keepGoing) {
        keepGoing = flipCardAndDetermineKeepGoing(deck, investment, tokens, growthFactor);
      }
      igms.putDeck(deck);
    }
    playAgainPrompt();
  }

  private boolean chancesOfWinningOrLosingInevitable(int cardsRemaining, int winsRemaining) {
    boolean keepGoing = true;
    if(cardsRemaining == winsRemaining || winsRemaining == 0) {
      int chancesOfWinning = winsRemaining == 0 ? 0 : 100;
      System.out.println("Chances of winning are " + chancesOfWinning + "%, so the game is over.");
      printEndMessage();
      keepGoing = false;
    }
    return keepGoing;
  }

  private boolean flipCardAndDetermineKeepGoing(Deck deck, int investment, int tokens, int growthFactor) {
    InvestmentGameModelService igms = ServiceHolder.investmentGameModelService;
    boolean keepGoing = true;
    if(deck.cards.length > 0) {
      Card card = deck.drawCard();
      if(card.status == WinningStatus.win) {
        System.out.println("Your investment of " + investment + " has multiplied by " + growthFactor);
        tokens += investment * growthFactor - investment;
        igms.putTokens(tokens);
      } else {
        tokens -= investment;
        keepGoing = printBankrupcyMessageAndDetermineKeepGoing(tokens, deck);
        igms.putTokens(tokens);
      }
    } else {
      System.out.println("Your total money is " + tokens + ". Congratulations!");
      keepGoing = false;
    }
    return keepGoing;
  }

  private void turnlyStatReport(int tokens, int tokenGoal, Deck deck, int growthFactor) {
    System.out.print("You currently have " + tokens + " tokens. ");
    if(tokens < tokenGoal) {
      System.out.println("You need " + (tokenGoal - tokens) + " tokens to reach your token goal of " + tokenGoal + ". ");
    } else {
      System.out.println("You are ahead of your goal of " + tokenGoal + " tokens by " + (tokens - tokenGoal) + " tokens.");
    }
    System.out.println("There are " + deck.calcWinsRemaining() +
      " wins left out of the " + deck.cards.length + " total cards. Your chances of winning are " +
      deck.getOddsOfWinAsPercentage() + ". ");
    System.out.print("Growth factor is " + growthFactor + ". ");
  }

  private int userInvestmentPromptAndGetInvestment(int tokens) {
    System.out.println("How much do you want to invest?");
    Scanner scanner = new Scanner(System.in);
    int investment = scanner.nextInt();
    if(investment > tokens) {
      System.out.println("Your investment is greater than your number of tokens. Investing all " + tokens + " tokens.");
      investment = tokens;
    } else if(investment <= 0) {
      System.out.println("Investment cannot be less than one. Investing 1");
      investment = 1;
    }
    return investment;
  }

  private void printEndMessage() {
    InvestmentGameModelService igms = ServiceHolder.investmentGameModelService;
    int tokens = igms.getTokens();
    int tokenGoal = igms.getTokenGoal();
    System.out.println("Your total money is " + tokens + ". ");
    if(tokens >= tokenGoal) {
      System.out.println("Congratulations! You have exceeded your token goal of " + tokenGoal + " by " + (tokens - tokenGoal) + " tokens.");
    } else {
      System.out.println("Good try. You were only "  + (tokenGoal - tokens) + " tokens away from meeting your goal of " + tokenGoal + " tokens.");
    }
  }

  private boolean printBankrupcyMessageAndDetermineKeepGoing(int tokens, Deck deck) {
    boolean keepGoing = true;
    if(tokens <= 0) {
      System.out.println("Token total has reached 0. You have gone bankrupt...");
      System.out.println("There were " + deck.cards.length + " cards remaining, " + deck.calcWinsRemaining() + " of which were wins.");
      System.out.println("These were the cards left in the deck:");
      deck.printWinningStatusOfEachCard();
      keepGoing = false;
    }
    return keepGoing;
  }

  private void playAgainPrompt() {
    System.out.println("would you like to play again?");
    Scanner scanner = new Scanner(System.in);
    String userWantsToPlayAgain = scanner.nextLine();
    if(userWantsToPlayAgain.toLowerCase().equals("yes")) {
      play();
    }
  }

}

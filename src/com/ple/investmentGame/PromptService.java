package com.ple.investmentGame;

import java.util.Scanner;

public class PromptService {
  
  public static PromptService make() {
    return new PromptService();
  }

  public void start() {
    System.out.println("Separate the following with spaces to generate deck:");
    System.out.println("Winning cards; Total cards; Growth factor");
    Scanner scanner = new Scanner(System.in);
    String deckInputsAsStrings = scanner.nextLine();
    String[] deckInputsAsArrayOfStrings = deckInputsAsStrings.split(" ");
    int numberOfWins = Integer.parseInt(deckInputsAsArrayOfStrings[0]);
    int numberOfCards = Integer.parseInt(deckInputsAsArrayOfStrings[1]);
    Deck deck = Deck.generate(numberOfCards, numberOfWins);
    deck.shuffle();
    int growthFactor = Integer.parseInt(deckInputsAsArrayOfStrings[2]);
    deck.putGrowthFactor(growthFactor);
    InvestmentGameModelService igms = ServiceHolder.investmentGameModelService;
    igms.putDeck(deck);
    System.out.println("Enter your number of starting tokens:");
    int startingTokents = scanner.nextInt();
    igms.putTokens(startingTokents);
    confirmationMessage();
  }

  private void confirmationMessage() {
    InvestmentGameModelService igms = ServiceHolder.investmentGameModelService;
    Deck deck = igms.getDeck();
    int numberOfWins = deck.getNumberOfWins();
    int numberOfCards = deck.length();
    int growthFactor = deck.getGrowthFactor();
    int tokens = igms.getTokens();
    System.out.println("Your deck has " + numberOfWins + " wins and " + numberOfCards + " total cards, " +
      "with a growth factor of " + growthFactor + ". You have " + tokens + " tokens to start with.");
  }

  public void invest() {
    InvestmentGameModelService igsm = ServiceHolder.investmentGameModelService;
    Deck deck = igsm.getDeck();
    int tokens = igsm.getTokens();
    boolean keepGoing = deck.length() > 0;
    while(keepGoing) {
      System.out.println("You currently have " + tokens + " tokens. There are " + deck.getNumberOfWins() +
        " wins left out of the " + deck.length() + " total cards. Your chances of winning are " +
        deck.getOddsOfWinAsPercentage() + ".");
      System.out.println("How much do you want to invest?");
      Scanner scanner = new Scanner(System.in);
      int investment = scanner.nextInt();
      if(investment > tokens) {
        System.out.println("Your investment is greater than your number of tokens. Investing all " + tokens + " tokens.");
        investment = tokens;
      }
      if(deck.length() > 0) {
        Card card = deck.drawCard();
        if(card.status == WinningStatus.win) {
          int growthFactor = deck.getGrowthFactor();
          System.out.println("Your investment of " + investment + " has multiplied by " + growthFactor);
          tokens += investment * growthFactor - investment;
          igsm.putTokens(tokens);
        } else {
          tokens -= investment;
        }
      } else {
        System.out.println("Your total money is " + tokens + ". Congratulations!");
        keepGoing = false;
      }
    }
    //Your total money is 5 tokens. There are 2 wins left out of 4 total cards. Your chances of winning are 50%.
    //How much do you want to invest?
    //1
    //Loss...
    //Your total money is 4 tokens. There are 2 wins left out of 3 total cards. Your chances of winning are 66.67%.
    //How much do you want to invest?
    //3
    //Win!
      //Your investment of 3 has multiplied by 2!
      //Your total money is 6 tokens. There is 1 win left out of 2 total cards. Your chances of winning are 50%.
    //How much do you want to invest?
    //4
    //Win!
      //Your investment of 6 has multiplied by 2!
      //Your total money is 12 tokens. Congratulations!

  }

}

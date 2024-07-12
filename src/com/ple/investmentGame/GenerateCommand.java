package com.ple.investmentGame;

import java.util.Scanner;

public class GenerateCommand extends Command {
  @Override
  public void execute() {
    System.out.println("Enter total number of cards followed by the number of wins, separated by a space:");
    Scanner scanner = new Scanner(System.in);
    String deckInputsAsStrings = scanner.nextLine();
    String[] deckInputsAsArrayOfStrings = deckInputsAsStrings.split(" ");
    int numberOfCards = Integer.parseInt(deckInputsAsArrayOfStrings[0]);
    int numberOfWins = Integer.parseInt(deckInputsAsArrayOfStrings[1]);
    Deck deck = Deck.generate(numberOfCards, numberOfWins);
    deck.shuffle();
    InvestmentGameModelService igms = ServiceHolder.investmentGameModelService;
    igms.putDeck(deck);
    //for testing purposes...
    deck.printWinningStatusOfEachCard();
  }

  @Override
  public UserDestination getUserDestination() {
    return UserDestination.mainPrompt;
  }
}

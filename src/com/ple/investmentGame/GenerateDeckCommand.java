package com.ple.investmentGame;

import java.util.Scanner;

public class GenerateDeckCommand extends Command {
  @Override
  public void execute() {
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
    //for test
    deck.printWinningStatusOfEachCard();
    System.out.println("growth factor = " + deck.getGrowthFactor());
  }

  @Override
  public UserDestination getUserDestination() {
    return UserDestination.nowhere;
  }
}

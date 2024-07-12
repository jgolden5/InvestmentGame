package com.ple.investmentGame;

import static com.ple.investmentGame.WinningStatus.*;

public class Main {
  public static void main(String[] args) {
    Deck deck = Deck.generate(30, 20);
    deck.shuffle();
    deck.printWinningStatusOfEachCard();
    deck.drawCard();
    deck.printWinningStatusOfEachCard();
    System.out.println(deck.getOddsOfWinAsPercentage());
  }
}

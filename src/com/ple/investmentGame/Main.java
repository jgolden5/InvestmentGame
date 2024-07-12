package com.ple.investmentGame;

import static com.ple.investmentGame.WinningStatus.*;

public class Main {
  public static void main(String[] args) {
    UserUtil uu = UserUtil.make();
    Deck deck = Deck.generate(0, 0);
    deck.shuffle();
    deck.printWinningStatusOfEachCard();
    deck.drawCard();
    deck.printWinningStatusOfEachCard();
    System.out.println(deck.getOddsOfWinAsPercentage());
  }
}

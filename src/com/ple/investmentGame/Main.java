package com.ple.investmentGame;

import static com.ple.investmentGame.WinningStatus.*;

public class Main {
  public static void main(String[] args) {
    Card[] cards = new Card[5];
    cards[0] = new Card(win);
    cards[1] = new Card(loss);
    cards[2] = new Card(loss);
    cards[3] = new Card(loss);
    cards[4] = new Card(loss);
    Deck deck = new Deck(cards);
    deck.shuffle();
    deck.printWinningStatusOfEachCard();
    System.out.println(deck.getOddsOfWinAsPercentage());
  }
}

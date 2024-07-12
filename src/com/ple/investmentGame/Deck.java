package com.ple.investmentGame;

import java.util.Random;

import static com.ple.investmentGame.WinningStatus.win;

public class Deck {
  public Card[] cards;
  public int numberOfWinsRemaining;
  public Deck(Card[] cards) {
    this.cards = cards;
    this.numberOfWinsRemaining = getNumberOfWinsRemaining();
  }

  private int getNumberOfWinsRemaining() {
    int numberOfWinsRemaining = 0;
    for(Card card : cards) {
      if(card.status == win) {
        numberOfWinsRemaining++;
      }
    }
    return numberOfWinsRemaining;
  }

  public String getOddsOfWinAsPercentage() {
    double odds = (double)numberOfWinsRemaining / (double)cards.length;
    double oddsAsPercentage = (odds * 100);
    double oddsAsPercentageToTheHundredth = 0.01 * Math.floor(oddsAsPercentage * 100);
    return oddsAsPercentageToTheHundredth + "%";
  }

  public void shuffle() {
    Random rnd = new Random();
    for (int i = cards.length - 1; i > 0; i--) {
      int rndIndex = rnd.nextInt(i + 1);
      Card cardBeingShuffled = cards[rndIndex];
      cards[rndIndex] = cards[i];
      cards[i] = cardBeingShuffled;
    }
  }

  public void printWinningStatusOfEachCard() {
    for(Card card : cards) {
      System.out.println(card.status);
    }
  }

}

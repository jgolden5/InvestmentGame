package com.ple.investmentGame;

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
    String oddsAsPercentageString = oddsAsPercentageToTheHundredth + "%";
    return oddsAsPercentageString;
  }

}

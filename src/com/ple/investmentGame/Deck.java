package com.ple.investmentGame;

import java.util.Random;

import static com.ple.investmentGame.WinningStatus.*;

public class Deck {
  public Card[] cards;
  private int numberOfWinsRemaining;

  private Deck(Card[] cards) {
    this.cards = cards;
    this.numberOfWinsRemaining = getNumberOfWinsRemaining();
  }

  public static Deck generate(int numberOfCards, int numberOfWins) {
    Card[] generatedCards = new Card[numberOfCards];
    for(int i = 0; i < numberOfCards; i++) {
      if(i < numberOfWins) {
        generatedCards[i] = new Card(win);
      } else {
        generatedCards[i] = new Card(loss);
      }
    }
    return new Deck(generatedCards);
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
    int cardNumber = 1;
    for(Card card : cards) {
      System.out.println(cardNumber + ". " + card.status);
      cardNumber++;
    }
  }

}

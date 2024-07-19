package com.ple.investmentGame;

import java.util.Random;

import static com.ple.investmentGame.WinningStatus.*;

public class Deck {

  public Card[] cards;
  public int numberOfWins;
  private int growthFactor;

  private Deck(Card[] cards) {
    this.cards = cards;
    this.numberOfWins = calcWinsRemaining();
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

  public int calcWinsRemaining() {
    int numberOfWinsRemaining = 0;
    for(Card card : cards) {
      if(card.status == win) {
        numberOfWinsRemaining++;
      }
    }
    return numberOfWinsRemaining;
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

  public void superShuffle() {
    int i = 0;
    while(i < 500) {
      shuffle();
      i++;
    }
  }

  public void printWinningStatusOfEachCard() {
    int cardNumber = 1;
    for(Card card : cards) {
      System.out.println(cardNumber + ". " + card.status);
      cardNumber++;
    }
    System.out.println();
  }

  public String getOddsOfWinAsPercentage() {
    int numberOfWins = calcWinsRemaining();
    double odds = (double) numberOfWins / (double)cards.length;
    double oddsAsPercentage = (odds * 100);
    double oddsAsPercentageToTheHundredth = 0.01 * Math.floor(oddsAsPercentage * 100);
    return oddsAsPercentageToTheHundredth + "%";
  }

  public Card drawCard() {
    Card topCard = null;
    if(cards.length > 0) {
      topCard = cards[0];
      System.out.println(topCard.status);
      removeTopCard();
    } else {
      System.out.println("There are no cards left in the deck");
    }
    return topCard;
  }

  private void removeTopCard() {
    Card[] newCards = new Card[cards.length - 1];
    for(int i = 0; i < cards.length - 1; i++) {
      newCards[i] = cards[i + 1];
    }
    cards = newCards;
  }

  public void putGrowthFactor(int growthFactor) {
    this.growthFactor = growthFactor;
  }

  public int getGrowthFactor() {
    return growthFactor;
  }

  public int length() {
    return cards.length;
  }

}

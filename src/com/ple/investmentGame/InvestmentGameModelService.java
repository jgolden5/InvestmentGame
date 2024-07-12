package com.ple.investmentGame;

public class InvestmentGameModelService {
  public Deck deck;

  public static InvestmentGameModelService make() {
    return new InvestmentGameModelService();
  }

  public Deck getDeck() {
    return deck;
  }

  public void putDeck(Deck deck) {
    this.deck = deck;
  }

}

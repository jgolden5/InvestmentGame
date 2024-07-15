package com.ple.investmentGame;

public class InvestmentGameModelService {
  public Deck deck;
  private int tokens;

  public static InvestmentGameModelService make() {
    return new InvestmentGameModelService();
  }

  public Deck getDeck() {
    return deck;
  }

  public void putDeck(Deck deck) {
    this.deck = deck;
  }

  public int getTokens() {
    return tokens;
  }

  public void putTokens(int tokens) {
    this.tokens = tokens;
  }

}

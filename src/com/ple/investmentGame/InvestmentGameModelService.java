package com.ple.investmentGame;

public class InvestmentGameModelService {
  private Deck deck;
  private int tokens;
  private int tokenGoal;

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

  public int getTokenGoal() {
    return tokenGoal;
  }

  public void putTokens(int tokens) {
    this.tokens = tokens;
  }

  public void putTokenGoal(int tokenGoal) {
    this.tokenGoal = tokenGoal;
  }
}

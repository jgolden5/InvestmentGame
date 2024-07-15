package com.ple.investmentGame;

public class PromptService {
  
  public static PromptService make() {
    return new PromptService();
  }

  public void generateDeck() {
    new GenerateDeckCommand().execute();
  }

  public void invest() {
  }

}

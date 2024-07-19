package com.ple.investmentGame;

public class Main {
  public static void main(String[] args) {
    PromptService promptService = PromptService.make();
    System.out.println("Welcome to the Investment Game!\n");
    promptService.play();
  }
}

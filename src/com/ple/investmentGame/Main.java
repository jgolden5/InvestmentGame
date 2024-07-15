package com.ple.investmentGame;

public class Main {
  public static void main(String[] args) {
    PromptService promptService = PromptService.make();
    promptService.generateDeck();
    //start prompt asks how many cards are wanted in deck, and calls deck.generate based on user inputs
    promptService.invest();
    //"Your total money is " + tokens + " tokens. There are " + numberOfWinsLeft + " wins left out of " +
      // numberOfCardsLeft + " total cards. Your chances of winning are " + chancesOfWinningAsPercent + "."
    // How much do you want to invest?
    // call deck.placeBet based on user input
    // placeBet method says either Win! or Loss...,
    // If top card is a win, the following is displayed = "Your investment of " + investmentAmount + " has
      // multiplied by " + growthFactor + "!". (If it's a loss, it skips this, and goes directly back to looping through promptService.play)
    // loop back to the beginning of promptService.play
    /*
    Enter a command...
    start
    How many cards do you want in your deck? (total *space* wins)
    5 2
    Your total money is 15 tokens. There are 2 wins left out of 5 total cards. Your chances of winning are 40%.
    How much do you want to invest?
    10
    Loss...
    Your total money is 5 tokens. There are 2 wins left out of 4 total cards. Your chances of winning are 50%.
    How much do you want to invest?
    1
    Loss...
    Your total money is 4 tokens. There are 2 wins left out of 3 total cards. Your chances of winning are 66.67%.
    How much do you want to invest?
    3
    Win!
    Your investment of 3 has multiplied by 2!
    Your total money is 6 tokens. There is 1 win left out of 2 total cards. Your chances of winning are 50%.
    How much do you want to invest?
    4
    Win!
    Your investment of 6 has multiplied by 2!
    Your total money is 12 tokens. Congratulations!

     */
  }
}

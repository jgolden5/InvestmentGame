package com.ple.investmentGame;

import java.util.HashMap;
import java.util.Scanner;

public class UserUtil {

  private final HashMap<String, Command> keymap = new HashMap<>();

  public static UserUtil make() {
    return new UserUtil();
  }

  private UserUtil() {
    initializeKeymap();
  }

  private void initializeKeymap() {
    keymap.put("exit", new ExitCommand());
    keymap.put("generateDeck", new GenerateDeckCommand());
    keymap.put("play", new PlayCommand());

  }

  public void startPrompt(String promptName) {
    Prompt prompt = getPrompt(promptName);
    prompt.start();
  }

//  public void startPrompt() {
//    boolean keepGoing = true;
//    while(keepGoing) {
//      Scanner scanner = new Scanner(System.in);
//      System.out.println("Type a command:");
//      String commandAsString = scanner.nextLine();
//      Command command = keymap.get(commandAsString);
//      UserDestination userDestination = UserDestination.start;
//      if(command != null) {
//        userDestination = command.executeAndGetUserDestination();
//      } else {
//        System.out.println("Command not recognized");
//      }
//      if(userDestination == UserDestination.exit) {
//        keepGoing = false;
//      } else if(userDestination == UserDestination.play) {
//        playPrompt();
//        keepGoing = false;
//      }
//    }
//  }

  private void playPrompt() {
    InvestmentGameModelService igms = ServiceHolder.investmentGameModelService;
    Deck deck = igms.deck;
    System.out.println("Your deck has " + deck.cards.length + " cards total, and " +
      deck.numberOfWinsRemaining + " wins remaining. Your odds of a win are " + deck.getOddsOfWinAsPercentage());
    Scanner scanner = new Scanner(System.in);

  }

}

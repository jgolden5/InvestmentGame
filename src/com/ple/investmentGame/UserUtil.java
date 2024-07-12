package com.ple.investmentGame;

import java.util.HashMap;
import java.util.Scanner;

public class UserUtil {

  private HashMap<String, Command> keymap = new HashMap<>();

  public static UserUtil make() {
    return new UserUtil();
  }

  private UserUtil() {
    initializeKeymap();
  }

  private void initializeKeymap() {
    keymap.put("exit", new ExitCommand());

  }

  public void prompt() {
    boolean keepGoing = true;
    while(keepGoing) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Type a command:");
      String commandAsString = scanner.nextLine();
      Command command = keymap.get(commandAsString);
      UserDestination userDestination = UserDestination.prompt;
      if(command != null) {
        userDestination = command.executeAndGetUserDestination();
      } else {
        System.out.println("Command not recognized");
      }
      if(userDestination == UserDestination.exit) {
        keepGoing = false;
      }
    }
  }

}

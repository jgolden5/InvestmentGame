package com.ple.investmentGame;

import java.util.Scanner;

public class UserUtil {
  public static UserUtil make() {
    return new UserUtil();
  }

  public void prompt() {
    boolean keepGoing = true;
    while(keepGoing) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Type a command:");
      String commandAsString = scanner.nextLine();
      Command command = getCommandFromString(commandAsString);
      UserDestination userDestination = UserDestination.prompt;
      if(command != null) {
        userDestination = command.executeAndGetUserDestination();
      }
      if(userDestination == UserDestination.exit) {
        keepGoing = false;
      }
    }
  }

  private Command getCommandFromString(String commandAsString) {
    Command command;
    switch(commandAsString) {
      case "exit", "q":
        command = new ExitCommand();
        break;
      default:
        System.out.println("Command " + commandAsString + " not recognized.");
        command = null;
    }
    return command;
  }

}

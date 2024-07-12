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
      if(command != null) command.execute();
    }
  }

  private Command getCommandFromString(String commandAsString) {
    switch(commandAsString) {
      case "exit", "q":
        return new ExitCommand();
        break;
      default:
        System.out.println("Command " + commandAsString + " not recognized.");
        return null;
    }
  }

}

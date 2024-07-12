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
      Command command = getCommandFromString();
      command.execute();
    }
  }

}

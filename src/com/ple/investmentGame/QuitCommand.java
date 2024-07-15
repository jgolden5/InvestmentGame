package com.ple.investmentGame;

public class QuitCommand extends Command {
  @Override
  public void execute() {
    System.out.println("Are you sure you want to quit?");
  }

  @Override
  public UserDestination getUserDestination() {
    return UserDestination.exit;
  }

}

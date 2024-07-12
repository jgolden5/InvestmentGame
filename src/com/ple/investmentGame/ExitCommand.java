package com.ple.investmentGame;

public class ExitCommand extends Command {
  @Override
  public void execute() {
    System.out.println("Successfully exited user prompt");
  }

  @Override
  public UserDestination getUserDestination() {
    return UserDestination.exit;
  }

}

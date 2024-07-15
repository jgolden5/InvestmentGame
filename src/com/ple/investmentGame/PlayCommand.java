package com.ple.investmentGame;

public class PlayCommand extends Command {
  @Override
  public void execute() {
    new GenerateCommand().execute();
    System.out.println("beginning game...");
  }

  @Override
  public UserDestination getUserDestination() {
    return UserDestination.play;
  }
}

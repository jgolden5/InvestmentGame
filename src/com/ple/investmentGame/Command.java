package com.ple.investmentGame;

public abstract class Command {
  public UserDestination executeAndGetUserDestination() {
    execute();
    return getUserDestination();
  }
  public abstract void execute();
  public abstract UserDestination getUserDestination();
}

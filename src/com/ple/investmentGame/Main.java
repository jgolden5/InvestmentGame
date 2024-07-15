package com.ple.investmentGame;

public class Main {
  public static void main(String[] args) {
    UserService userService = ServiceHolder.userService;
    userService.startPrompt("main");
  }
}

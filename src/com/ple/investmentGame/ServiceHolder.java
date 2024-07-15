package com.ple.investmentGame;

public class ServiceHolder {
  public static InvestmentGameModelService investmentGameModelService = InvestmentGameModelService.make();
  public static UserService userService = UserService.make();
}

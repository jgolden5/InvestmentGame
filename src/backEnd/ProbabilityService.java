package backEnd;

public class ProbabilityService {
  public static String getOddsOfWinAsPercentage(double winsLeftInDeck, double cardsRemaining) {
    double odds = winsLeftInDeck / cardsRemaining;
    double oddsAsPercentage = (odds * 100);
    double oddsAsPercentageToTheHundredth = 0.01 * Math.floor(oddsAsPercentage * 100);
    String oddsAsPercentageString = oddsAsPercentageToTheHundredth + "%";
    return oddsAsPercentageString;
  }
}

const startingInvestmentInput = document.getElementById("startingInvestmentInput");
const numberOfWinCardsInput = document.getElementById("numberOfWinCardsInput");
const deckSizeInput = document.getElementById("deckSizeInput");

const startButton = document.getElementById("startButton");
startButton.addEventListener("click", () => gameStart(startingInvestmentInput.value, numberOfWinCardsInput.value, deckSizeInput.value));

let winningCardsRemaining, investmentRemaining, cardsRemaining, winChance;

function gameStart(startingInvestmentInput, numberOfWinCardsInput, deckSizeInput) {
  if(startingInvestmentInput > 0 && numberOfWinCardsInput > 0 && deckSizeInput > 0) {
    investmentRemaining = startingInvestmentInput;
    winningCardsRemaining = numberOfWinCardsInput;
    cardsRemaining = deckSizeInput;
    winChance = calcWinChanceAsPercentage(winningCardsRemaining, cardsRemaining);
    document.getElementById("heading").innerText = winChance + " chance of winning...";
    document.getElementById("investmentRemaining").innerText = "Investment Remaining = " + investmentRemaining;
    document.getElementById("winningCardsRemaining").innerText = "Winning Cards Remaining = " + winningCardsRemaining;
    document.getElementById("cardsRemaining").innerText = "Cards Remaining = " + cardsRemaining;
    document.getElementById("startingInputs").style = "display: none";
    document.getElementById("startButton").style = "display: none";
    document.getElementById("card").style = "display: flex";
  } else {
    document.getElementById("errorMessage").innerText = "Error: Please fill in each of the fields with a number greater than 0."
    setTimeout(() => {
      document.getElementById("errorMessage").innerText = ""
    }, 1000)
  }
}

function calcWinChanceAsPercentage(winningCardsRemaining, cardsRemaining) {
  return Math.round(winningCardsRemaining / cardsRemaining * 100 * 100) / 100 + '%';
}

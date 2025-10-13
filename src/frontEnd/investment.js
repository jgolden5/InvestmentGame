const startingInvestmentInput = document.getElementById("startingInvestmentInput");
const increasePerWinInput = document.getElementById("increasePerWinInput");
const deckSizeInput = document.getElementById("deckSizeInput");

const startButton = document.getElementById("startButton");
startButton.addEventListener("click", () => gameStart(startingInvestmentInput.value, increasePerWinInput.value, deckSizeInput.value));

let percentIncreasePerWin, investmentRemaining, cardsRemaining;

function gameStart(startingInvestmentInput, increasePerWinInput, deckSizeInput) {
  if(startingInvestmentInput > 0 && increasePerWinInput > 0 && deckSizeInput > 0) {
    investmentRemaining = startingInvestmentInput;
    percentIncreasePerWin = increasePerWinInput;
    cardsRemaining = deckSizeInput;
    document.getElementById("investmentRemaining").innerText = "Investment Remaining = " + investmentRemaining;
    document.getElementById("cardsRemaining").innerText = "Cards Remaining = " + cardsRemaining;
    document.getElementById("startingInputs").style = "display: none";
    document.getElementById("startButton").style = "display: none";
    document.getElementById("card").style = "display: flex";
  } else {
    document.getElementById("errorMessage").innerText = "Error: Please fill in each of the fields with a number greater than 0."
    setTimeout(() => {
      document.getElementById("errorMessage").innerText = ""
      location.reload();
    }, 1000)
  }
}

const startingInvestmentInput = document.getElementById("startingInvestmentInput");
const numberOfWinCardsInput = document.getElementById("numberOfWinCardsInput");
const deckSizeInput = document.getElementById("deckSizeInput");

const startButton = document.getElementById("startButton");
startButton.addEventListener("click", () => gameStart(startingInvestmentInput.value, numberOfWinCardsInput.value, deckSizeInput.value));

let winningCardsRemaining, investmentRemaining, cardsRemaining, winChance;

const deck = [];

function gameStart(startingInvestmentInput, numberOfWinCardsInput, deckSizeInput) {
  if(startingInvestmentInput > 0 && numberOfWinCardsInput > 0 && deckSizeInput > 0) {
    investmentRemaining = startingInvestmentInput;
    winningCardsRemaining = numberOfWinCardsInput;
    cardsRemaining = deckSizeInput;
    generateDeck(winningCardsRemaining, cardsRemaining);
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

function generateDeck(winningCardsRemaining, cardsRemaining) {
  let i = 0;
  while(i < winningCardsRemaining) {
    deck.push(true); //true == winning card
    i++;
  }
  while(i < cardsRemaining) {
    deck.push(false); //false == losing card
    i++;
  }
  shuffle(deck, 15);
  console.log(deck); //temp
}

function shuffle(unshuffledDeck, timesToShuffle) {
  shuffledDeck = unshuffledDeck;
  t = 0;
  while(t < timesToShuffle) {
    for(let i = 0; i < shuffledDeck.length; i++) {
      const r = Math.floor(Math.random() * (i + 1));
      let temp = shuffledDeck[i];
      shuffledDeck[i] = shuffledDeck[r];
      shuffledDeck[r] = temp;
    }
    t++;
  }
}

function calcWinChanceAsPercentage(winningCardsRemaining, cardsRemaining) {
  return Math.round(winningCardsRemaining / cardsRemaining * 100 * 100) / 100 + '%';
}

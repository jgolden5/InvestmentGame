const startingInvestmentInput = document.getElementById("startingInvestmentInput");
const numberOfWinCardsInput = document.getElementById("numberOfWinCardsInput");
const deckSizeInput = document.getElementById("deckSizeInput");

const card = document.getElementById("card");

const startButton = document.getElementById("startButton");
startButton.addEventListener("click", () => gameStart(startingInvestmentInput.value, numberOfWinCardsInput.value, deckSizeInput.value));

card.addEventListener("click", function() {
  if(window.getComputedStyle(card).backgroundColor == "rgb(255, 255, 0)") {
    drawCard();
  } else {
    nextCard();
  }
});

let deck = [];

let winningCardsRemaining, investmentRemaining, winChance;

function gameStart(startingInvestmentInput, numberOfWinCardsInput, deckSizeInput) {
  if(startingInvestmentInput > 0 && numberOfWinCardsInput > 0 && deckSizeInput > 0) {
    investmentRemaining = startingInvestmentInput;
    winningCardsRemaining = numberOfWinCardsInput;
    deck = generateDeck(winningCardsRemaining, deckSizeInput);
    displayGameStats()
    document.getElementById("startingInputs").style = "display: none";
    startButton.style = "display: none";
    card.style = "display: flex";
    card.innerText = "Flip Card";
  } else {
    document.getElementById("errorMessage").innerText = "Error: Please fill in each of the fields with a number greater than 0."
    setTimeout(() => {
      document.getElementById("errorMessage").innerText = ""
    }, 1000)
  }
}

function displayGameStats() {
  winChance = calcWinChanceAsPercentage(winningCardsRemaining);
  document.getElementById("heading").innerText = winChance + " chance of winning...";
  document.getElementById("investmentRemaining").innerText = "Investment Remaining = " + investmentRemaining;
  document.getElementById("winningCardsRemaining").innerText = "Winning Cards Remaining = " + winningCardsRemaining;
  document.getElementById("cardsRemaining").innerText = "Cards Remaining = " + deck.length;
}

function generateDeck(winningCardsRemaining, deckSize) {
  let i = 0;
  while(i < winningCardsRemaining) {
    deck.push(true); //true == winning card
    i++;
  }
  while(i < deckSize) {
    deck.push(false); //false == losing card
    i++;
  }
  return shuffle(deck, 15);
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
  return shuffledDeck;
}

function calcWinChanceAsPercentage(winningCardsRemaining) {
  return Math.round(winningCardsRemaining / deck.length * 100 * 100) / 100 + '%';
}

function drawCard() {
  const cardIsAWin = deck[0];
  if(cardIsAWin) {
    card.style = "background-color:green";
    card.innerText = "Win!";
    winningCardsRemaining--;
  } else {
    card.style = "background-color:red";
    card.innerText = "Loss...";
  }
  deck.shift();
  displayGameStats();
}

function nextCard() {
  card.style.backgroundColor = "yellow";
  card.innerText = "Flip Card"
}

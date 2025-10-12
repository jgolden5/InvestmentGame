const startGameButton = document.getElementById("startGame")
startGameButton.addEventListener("click", () => hideElement("hiddenP"));
function hideElement(idOfElementToHide) {
  const hidden = document.getElementById(idOfElementToHide)
  if(hidden.style.display === "none") {
    hidden.style.display = "block";
  } else {
    hidden.style.display = "none";
  }
}

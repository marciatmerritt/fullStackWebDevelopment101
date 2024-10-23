
const addEventListeners = (param1, callback, eventType = 'click') => {

    const startBtn = document.querySelector(param1);

    console.log(startBtn);
    startBtn.addEventListener(eventType, callback);

};
  
//returns random number between 1 * 25
//Math.floor(Math.random() * 25) + 1;
// function getRndInteger(min, max) {
//     return Math.floor(Math.random() * (max - min + 1) ) + min;
//   }

const startGame = (event) => {
    console.log("Start Game Start");
    console.log(event);

    //blank array that will hold the numbers I already have
    let numbers = [];
    //buttons that I need to 
    let numberButtons = getNumberButtons();
    console.log(numberButtons);
    
}

const getRandomInteger = (min, max) => {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}
/**
* Helper method to get the number buttons
*/
const getNumberButtons = () => document.querySelectorAll('.tile');

addEventListeners(".submitBtn", startGame);
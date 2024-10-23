/**
 * Adds Event Listeners
 * @param {string} action action to execute adding event listeners
 * @param {string} param1 element's id or class
 * @param {function} callback function to be run on event action
 * @param {string} eventType defaults to click, but can be any event type
 */
const addEventListeners = (action, param1, callback, eventType = 'click') => {

    if (action == "start"){
        const startBtn = document.querySelector(param1);
        startBtn.addEventListener(eventType, callback);
    };

    if (action == "begin"){
        const numberButtons = getNumberButtons();
        for(const numberButton of numberButtons){
            numberButton.addEventListener(eventType, callback);
        }
    };   
};
/**
 * Start Game Event: Adds a random number to each button on the screen
 * @param {event} event 
 */
const startGame = (event) => {

    revertColors();

    addEventListeners("begin", ".tile", makeSelection);

    shuffleButtons();
    
};
/**
 * Generates a random number between 1 & 25 without duplicates
 * @param {number} min 
 * @param {number} max 
 * @param {array} numbers 
 * @returns {number} random number between 1 & 25 
 */
const generateUniqueRandomNbr = (min, max, numbers) => {

    let randomNumber = null;

    do {
        randomNumber = getRandomInteger(Number(min), Number(max));
    } while (numbers.includes(randomNumber));

    return randomNumber;
};
/**
 * Gets a random number between min & max (both included)
 * @param {number} min 
 * @param {number} max 
 * @returns {number}
 */
const getRandomInteger = (min, max) => {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}
/**
* Helper method to get the number buttons
*/
const getNumberButtons = () => document.querySelectorAll('.tile');

const shuffleButtons = () => {

    let randomNumber = null;
    let numbers = []; //array to hold list of random numbers to prevent duplicates
    let numberButtons = getNumberButtons(); //gets all buttons with class = tile

    const sortedNumbers = collectNumbers(); //get numbers from buttons that haven't been selected to find the max & min 
    const min = sortedNumbers[0]; //1st number in the table of sorted #s
    const max = sortedNumbers[(sortedNumbers.length - 1)]; //last # in the table of sorted #s
        
    for (const numberButton of numberButtons){
        randomNumber = generateUniqueRandomNbr(min, max, numbers);
        numberButton.innerText = randomNumber;
        numbers.push(randomNumber);
    }
};
/**
 * event handler
 * @param {event} event - click event
 */
const makeSelection = (event) =>{

    const selectedButton = (event.target);
    const sortedNumbers = collectNumbers(); //collect all numbers on buttons & sort
    const count = counter(sortedNumbers); //1st # on table of sorted #s

    const isInNumberOrder = isValidSelection(count, selectedButton);

    if (!isInNumberOrder){
        shuffleButtons(sortedNumbers);
        return;
    };

    addClass(selectedButton);
}

/**
 * collects numbers that have not been selected yet
 * @returns - sorted list of unselected buttons
 */
const collectNumbers = () =>{
    const numberTiles = getNumberButtons();
    numbers = [];
    for(const numberTile of numberTiles){
        numbers.push(numberTile.innerText);
    }
    const sortedNumbers = numbers.sort((a,b) => a-b);
    return sortedNumbers;
}

/**
 * determines current next number
 * @param {[number]} sortedNumbers - numbers sorted in ascending order
 * @returns - lowest value
 */
const counter = (sortedNumbers) =>{
    return sortedNumbers[0];
}

/**
 * determines if correct next number was selected
 * @param {number} count 
 * @param {button} selected button 
 */
const isValidSelection = (count, selectedButton) => {

    if(Number(selectedButton.innerText) == count){
        return true;
    };
    
    return false;   
}

/**
 * changes background color if it is correct and checks for win state
 * @param {button} selectedNumber 
 */
const addClass = (selectedNumber) =>{
    selectedNumber.classList.remove('tile');
    selectedNumber.classList.add('selected');
    remainingNumbers = collectNumbers();
    if(remainingNumbers.length == 0){
        winState();
    }
}

/**
 * displays text for win condition and reverts buttons to unselected state
 */
const winState = () => {
    document.querySelector('#winText').innerText = ('You Win!');
    revertColors();
}

/**
 * reverts buttons to unselected state
 */
const revertColors = () => {
    const numbers = document.querySelectorAll('.selected');
    for(number of numbers){
        number.classList.remove('selected');
        number.classList.add('tile');
    }
}

addEventListeners("start", "#startButton", startGame);

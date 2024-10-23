const buildOutButtons = () => {

    shuffleButtons();


}

/**
* Helper method to get the number buttons
*/
const getNumberButtons = () => document.querySelectorAll('.tile');
const newButton = () => document.createElement('button');
const min = () => 1;
const max = () => 25;

const generateUniqueRandomNbr = (min, max, numbers) => {

    let randomNumber = null;

    do {
        randomNumber = getRandomInteger(min, max);
    } while (numbers.includes(randomNumber));

    return randomNumber;
};
/**
 * Gets a random number between min & max including the min & max
 * @param {number} min 
 * @param {number} max 
 * @returns {number} 
 */
const getRandomInteger = (min, max) => {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}
const shuffleButtons = () => {

    let randomNumber = null;
    let numbers = []; //array to hold list of random numbers already used to prevent duplicates
    let numberButtons = getNumberButtons();
        
    for (const numberButton of numberButtons){
        randomNumber = generateUniqueRandomNbr(min, max, numbers);
        numberButton.innerText = randomNumber;
        numbers.push(randomNumber);
    } 
    
}
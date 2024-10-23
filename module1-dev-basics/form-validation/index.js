'use strict'
/**
 * Event handler that  validates only the inputs inside of the form that was submitted. If all inputs pass validation, submit the form, otherwise, prevent the form from being submitted and show error list on page at the top of the current form being validated
 * @param {SubmitEvent} event Click on Submit/Validate button
 */
const validateForm = (event) => {

    const submittedForm = event.target;
    const formInputs    = Array.from(submittedForm);

    //get div class=error above form validating and tag it
    const errorDiv = submittedForm.previousElementSibling;
    errorDiv.setAttribute("data-errors", "");
    errorDiv.replaceChildren();

    for (const formInput of formInputs){       //loop thru each form input to validate data for each input
      validateInputs(formInput);
    };
  
    errorDiv.removeAttribute("data-errors");   //remove tag
    const formErrorList = errorDiv.querySelector("#error-list");

    if (!formErrorList){
        return;
    };

    event.preventDefault();
};
/**
 *For each input, test that all information is entered correctly. 
 If an input, has multiple classes, test for each class requirement. 
 Shows all errors on the page in a bulleted list, without duplicating the errors. 
 * @param {*} input 
 */
const validateInputs = (element) => { 
    
    const input      = element;
    const inputValue = input.value.trim();

    const classIsRequired = input.classList.contains("required");

    if ((inputValue === "") && !classIsRequired){ //blank input that is not required shows no error
        return;
    };

    if ((inputValue === "") && classIsRequired){
        let errorMessage  = "Required fields must have a value that is not empty or whitespace.";
        setError(errorMessage);
    };

    const classIsAlphabetic = input.classList.contains("alphabetic");
    if (classIsAlphabetic && (isInputAlphabetic(inputValue) === false)){
        let errorMessage = "Alphabetic fields must be a series of alphabetic characters."
        setError(errorMessage);
    };

    const classIsDate = input.classList.contains("date");
    if (classIsDate && (isValidDate(inputValue) === false)){
        let errorMessage = "Date fields must match the format of XX/XX/XXXX."
        setError(errorMessage);
    };

    const classIsNumeric = input.classList.contains("numeric");
    if (classIsNumeric && (isInputNumeric(inputValue) === false)){
        let errorMessage = "Numeric fields must be a series of numbers."
        setError(errorMessage);
    };

    const classIsPassword = input.classList.contains("password");
    if (classIsPassword & (isValidPassword(inputValue) === false)){
        let errorMessage = "Password fields must contain one or more of each of the following types: uppercase letters, lowercase letters, numbers, special characters."
        setError(errorMessage);
    };

    const classIsPhone = input.classList.contains("phone");
    if (classIsPhone && (isValidPhone(inputValue) === false)){
        let errorMessage = "Phone fields must match the format of XXX-XXX-XXXX."
        setError(errorMessage);
    };

    const classIsRequiredSize = input.classList.contains("required_size");
    if (classIsRequiredSize){
        validateRequiredSize(input);
    };

    const classIsUsername = input.classList.contains("username");
    if (classIsUsername){
        validateUsername(input);
    };
};
/**
 * Gets minlength attribute from the input field
 * Checks what user entered in this field and makes sure it matches the required size entered in the minlength
 * Adds an error msg if checks fail
 * @param {element} input 
 */
const validateRequiredSize = (input) => {
  
    const minLength = Number(input.attributes.minLength.value);

    const isRequiredSize = isExactlyMinLength(minLength, input.value.trim());
    if (isRequiredSize === false){
      let errorMsg = "Required_size field lengths must exactly match the minlength attribute of that field."
      setError(errorMsg);
    };  
};
/**
 * Checks that the username entered by the user matches the required minlength, defaults to 8
 * Checks that the username entered consists of only numbers and letters
 * Sets error message if there are any errors found
 * @param {element} input 
 */
const validateUsername = (input) => {

    const inputValue     = input.value.trim();
    const isAlphanumeric = isInputAlphanumeric(inputValue);
    if (isAlphanumeric === false){
        let errorMsg   = "Username fields must contain only alphanumeric characters.";
        setError(errorMsg);
    };

    let minLength = 8;                //default username minlength to 8 for username

    const isRequiredSize = isMinLength(minLength, inputValue);
    if (isRequiredSize === false){
        let errorMsg   = "Username fields must contain at least 8 characters.";
        setError(errorMsg);
    };
};
/**
* Checks input to see if string is only letters
* @param {string} input
* @returns {boolean} true if string consists of only letters
*/
const isInputAlphabetic = (input) => {
    return /^[A-Za-z]+$/.test(input);
};
/**
* Checks input to see if string is only letters & numbers
* @param {string} input
* @returns {boolean} true if string contains only alphanumeric characters 
*/
const isInputAlphanumeric = (input) => {
    return /^[0-9A-Za-z]+$/.test(input);
};
/**
* Checks input to see if string is only numbers
* @param {string} input
* @returns {boolean} true if string consists of only numbers
*/
const isInputNumeric = (input) => {
    return /^[0-9]+$/.test(input);
};
/**
 * Checks to see if input is the required size in length
 * @param {number} minLength 
 * @param {string} input 
 * @returns {boolean} true if string is equal to the length parameter
 */
const isExactlyMinLength = (minLength, input) => {
    return (input.length === minLength);
};
/**
 * Checks to see if input is the required size in length
 * @param {number} minLength 
 * @param {string} input 
 * @returns {boolean} true if string is greater than or equal to the length parameter
 */
const isMinLength = (minLength, input) => {
    return (input.length >= minLength);
};
/**
* Checks input to see if string is in the mm/dd/yyyy date format only
* @param {string} input
* @returns {boolean} true if the string matches the mm/dd/yyyy format
*/
const isValidDate = (input) => {
    return /^\d{2}\/\d{2}\/\d{4}$/.test(input);
};
/**
 * Checks password, password must have at least 1 uppercase, 1 lowercase, 1 nbr, & 1 special char #?!@$_%^&*-+= 
 * @param {string} input 
 * @returns {boolean} true if string matches pswd criteria
 */
const isValidPassword = (input) => {
    return /^.*(?=.{4,})(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[#?!@$_%^&*-+=])(^[a-zA-Z0-9#?!@$_%^&*+=]+$)/.test
    (input);
};
/**
* Checks input to see if string is in the xxx-xxx-xxxx format
* @param {string} input
* @returns {boolean} true of string is in the xxx-xxx-xxxx format
*/
const isValidPhone = (input) => {
    return /^\d{3}\-\d{3}\-\d{4}$/.test(input);
};
/**
 * Creates an unordered list of error msgs in the div class=error just above the submitted form
 * Each list item will be unique
 * @param {string} message  
 */
const setError = (message) => {

    const errorDiv = document.querySelector("[data-errors]");
    let ul  = errorDiv.querySelector("ul");
    let li  = errorDiv.querySelectorAll("li");

    if (ul && li){      //make sure there are no duplicate error msgs
        let isDuplicate = isDuplicateErrorMsg(message, li);
        if (isDuplicate){   
            return;
        };
    };

    if (!ul){           //if ul node does not exist, create it
        ul = document.createElement('ul');
        ul.setAttribute("id", "error-list");
        errorDiv.appendChild(ul);
    };

    li = document.createElement("li");
    li.textContent = message;
    ul.appendChild(li);
};
/**
 * Search through list of error msgs already found to make sure that the new msg isn't a duplicate
 * @param {string} message 
 * @param {array} liElements 
 * @returns {boolean}
 */
const isDuplicateErrorMsg = (message, liElements) => {

    for (const liElement of liElements){
        if (message === liElement.textContent){
            return true;
        };
    };
    return false;
};
/** Add Event Listener to all forms submit button on the page */
const addEventListeners = () => {

    const forms = document.querySelectorAll("form");
  
    for (const form of forms){
      form.addEventListener('submit', validateForm);
    }
};

addEventListeners();
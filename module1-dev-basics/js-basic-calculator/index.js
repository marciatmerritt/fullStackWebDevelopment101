
const addButtonEventListeners = () => {

    const allClearButton  = document.querySelector(".all-clear");
    const operatorButtons = document.querySelectorAll("[data-operator]");

    allClearButton.addEventListener("click", clearAll);

    for (const button of operatorButtons){
        button.addEventListener("click", determineOperation);
    };
};
const determineOperation = (event) => {
    let total = 0;

    const operator = event.target.dataset.operator;

    const inputBox1Value = Number(document.querySelector(".box1").value);
    const inputBox2Value = Number(document.querySelector(".box2").value);

    if ((inputBox2Value == 0) && (operator === "/")){
        total = "ERROR: Cannot divide by 0";
        displayTotal(total);
        return;
    }

    switch(operator){
        case "+":
            total = inputBox1Value + inputBox2Value;
            break;
        case "-":
            total = inputBox1Value - inputBox2Value;
            break;
        case "*":
            total = inputBox1Value * inputBox2Value;
            break;
        case "/":
            total = inputBox1Value / inputBox2Value;
    };

    displayTotal(total);

}
const displayTotal = (total) => {

    let div = document.querySelector(".answer");

    div.innerText = total;
}
const clearAll = () => {
    const inputBox1 = document.querySelector(".box1");
    const inputBox2 = document.querySelector(".box2");
    const answerDiv = document.querySelector(".answer");

    inputBox1.value = "";
    inputBox2.value = "";
    answerDiv.innerText = "";
}

addButtonEventListeners();

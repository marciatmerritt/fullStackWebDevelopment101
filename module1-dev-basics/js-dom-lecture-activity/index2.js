// Event listeners let developers run functions based on events that happen after the
// code is already running. You can think of them like a special type of if statement that
// gets checked consistently rather than just running once. "Whenever this thing
// happens", then run some other code.

const taskButton = document.querySelector('button');
// console.log(taskButton);

const listItems = document.querySelectorAll('li');
console.log(listItems);


//events are always passed to the function when it is an event handler
const addTaskItemToList = (event) => {
    console.log(event);
    const inputValue = document.querySelector('input').value;

    const list = document.querySelector('ul');
    console.log(list);

    const li = document.createElement("li");
    const textNode = document.createTextNode(inputValue);
    li.appendChild(textNode);
    list.appendChild(li);
    addListItemEventListener();
};

const lineThrough = (event) => {
    console.log('test worked');
    const listItem = event.target;
    console.log(listItem);
    listItem.classList.toggle('completed');

}

/**Event Listeners 
 * use a fxn to add event listeners
*/

//no parameters passed when invoking the fxn
taskButton.addEventListener("click", addTaskItemToList);


const addListItemEventListener = (event) => {
    console.log(event);
    const listItem = document.querySelectorAll('li');

    for (const item of listItems){
        item.addEventListener('click', lineThrough);
    }
};

addListItemEventListener();

 
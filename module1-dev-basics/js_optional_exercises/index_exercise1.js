/* 1. 
Given two variables, `x` and `y`, swap their values so that `x` is less than `y`.
*/
const exercise1 = () =>{

    let x = 15;
    let y = 5;
    let hold_x;

    if (x > y){
        hold_x = x;
        x = y;
        y = hold_x;
}

console.log(`x: ${x}`);
console.log(`y: ${y}`);

}
/* 2.
Given three variables, `x`, `y`, and `z`, where `x` and `y` are both positive numbers. Set `z` to be a string of each value from 0 to `y` that is divisible by `x`.
 */
const exercise2 = () => {
    let x = 2;
    let y = 20;
    let z = "";

    for (let i = 0; i < y; i++){

        if (i % x === 0){
            z += i;
            console.log(z);
        }
    }
}

/* 3.
Given two variables, `x` and `y`, perform the following based on the value of `x`:
  1. `x = 'A'`: Set `y` to the value of `x`. 
  2. `x = 'B'`: Set `y` to 3 times the value of `y`.
  3. `x = 'C'`: Set `y` to be 0.
  4. `x = 'D'`: Set `y` to null
 */
const exercise3 = () =>{
    let x = 'B';
    let y = null;

    switch(x){
        case "A":
            y = x;
            break;
        case "B":
            y *= 3;
            break;
        case "C":
            y = 0;
            break;
        case "D":
            y = null;
            break;
        default:
            alert("Error: Invalid x: No Match Found");
    }
    
    console.log(`y: ${y}`);
}

/* Stretch
Given four variables, `x`, `y`, `even`, and `odd`, where `x` and `y` are positive numbers and `even` and `odd` start at 0; count how many numbers are even or odd between `x` and `y`.
*/
const exerciseStretch = () => {
    let x = 14;
    let y = 20;

    let odd = 0;
    let even = 0;

    for (let i = 0; x < y; i++){
        
        if ((x % 2) == 0){
            even ++;
        }else{
             odd ++;
        }

        x += 1;
    }

    console.log(`Total Even Numbers: ${even}`);
    console.log(`Total  Odd Numbers: ${odd}`);
}

// Function to add two numbers and return the result
function addNumbers(a, b) {
    return a + b;
}

console.log(addNumbers(10, 20));

/* 
   Arrow Function sumArray to add an array of numbers and return the result 
*/
let sumArray = (array) => {
    let sum = 0;
    array.forEach(element => {
        sum += element;
    });
    return sum;
}

console.log(sumArray([10, 20, 30, 40, 50]));

/* Function to find average of an array of numbers and return the result */ 
let findAverage = (array) => {
    let sum = 0;
    array.forEach(element => {
        sum += element;
    });
    return sum/array.length;
}

console.log(findAverage([10, 20, 30, 40, 50]));


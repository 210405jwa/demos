'use strict'; // Enable strict mode

// Should usually always use strict mode, because it helps you to avoid various bugs
// such as using a varible that is not explicitly declared using var, let, const

// This function doesn't have a name, and is being assigned to const x
let x = function() {
    console.log('Hello there');
};

x();

(function() {
    console.log('This is an anonymous function');
})();

// Closure example
x = function() {
    let name = 'John';

    function printName() {
        console.log(name);
        name += ' Doe';
        console.log(name);
    }

    return printName;
};

const returnedFunction = x();
returnedFunction();

// What are closures? They were something that basically exploited the fact that
// Inner functions that are returned would continue to have access to the outer
// function's variables. Before the module system was introduced to modern
// JavaScript development, closures were a way to keep variables isolated and
// protected in individual modules

/*

Functions: first-class, therefore can be passed around like any other value in JS

*/

// There are many different ways of defining functions:

// Function declaration
function a() {

};

// Function expression
const b = function() {

};

// Arrow functions
const c = () => {

};

// Arrow functions and regular functions have distinctions in how they treat 
// the 'this' keyword 

// Varargs
function varArgs(...ourParameters) {
    ourParameters.forEach(param => {
        console.log(param);
    });
}

varArgs('a', 'b', 'c', 1, 2, 3);
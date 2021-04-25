/*

There are 2 main scopes in JavaScript:
- Global scope
- Function scope

We saw this with the idea of hoisting, whereby functions and var variables are hoisted to the top of their scope.

The global scope basically defines the outermost level... or the level that these comments are in. Anything else inside a function will be of the function scope. And of course, we can also have block scope w/ let and const inside our loops, if statements, switch statements, etc.

*/

// In JavaScript, we can have nested functions
var c = 'I am a global scoped variable';

function outer() {
    var a = 'hello';
    var number = 10;

    function inner() {
        var obj = {
            key: 'value'
        };

        console.log(a);
        console.log(number);
        console.log(obj);
        
    }
    console.log(c);
    inner();
}

outer();

function myFunc() {

    for (let i = 1; i < 10; i++) {
        console.log(i);
    }

    // console.log(i); // can't do this, because let is not function scoped,
    // but is block scoped
}

myFunc();
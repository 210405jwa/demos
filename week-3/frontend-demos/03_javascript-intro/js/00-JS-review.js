/*

    Block comments

*/

// Single line comments

"use strict"; // this needs to be the first line of code at the top
// Helps us with things such as not being able to use a variable without declaring it first (var, let, const)

/* Functions */
function helloLog() {
    console.log('Hello from helloLog!');
}

function logMessage(message) {
    console.log(message);
    console.log(typeof(message));
}

helloLog();

logMessage('This is a string'); // string
logMessage(1234567890); // number
logMessage(19 / 5); // number
logMessage(20 - 'a'); // NaN (not a number)
logMessage(8 == '8'); // True (type coercion)
logMessage(8 === '8'); // False (strict comparison, no type coercion)
logMessage(null); // is an object (some people consider it a bug), but you might just think of it as the absence of an object
var m; // undefined
logMessage(m);
// dyanamic typing
m = 10;
m = 'A String';

/* Objects and Arrays */
// Object literal syntax. Every object literal will construct a new object
var obj = {
    id: 1,
    name: 'Revature',
    favoriteColor: 'orange',
    isObject: true
};

// arrays (dynamic, can change in size)
var arr = [1, 'Revature', 'orange', true];

console.log(obj);
console.log(arr);

var obj2 = {
    firstName: 'Hello',
    lastName: 'World',
    // Functions inside of objects are called methods, to be more specific
    greet: function() {
        // console.log('Hello, ' + this.firstName + ' ' + this.lastName);
        // Here we see the usage of the this keyword / variable
        // It basically points to the object that is actually calling the method
        console.log(this);
        console.log(`Hello, ${this.firstName} ${this.lastName}`);
    }
}

// let greet = obj2.greet;
// greet();

obj2.greet();

var obj3 = {
    firstName: 'Billy',
    lastName: 'Rodriguez',
    anotherProperty: "here's another property"
}

obj3.sayHello = obj2.greet; // We're having the sayHello property on obj3
// point to the function that is defined over on obj2

obj3.sayHello();

/* Scopes & Hoisting */
// In Java, there were originally 2 scopes:
// 1. Global scope
// 2. Function scope
// Then in ES6, a third scope was added
// 3. Block Scope (let and const)

// globalVar1 = 'This is a global variable' // Won't work in strict mode
var globalVar2 = 'I am a global scoped variable';

function myFunction() {
    var functionVar = 'I am a function scoped variable';

    /* ES6 added block scope */
    if (true) {
        var a = 'I am still a function scoped variable';
        let b = 'I am a block-scoped variable';
        console.log(b);

        const blockConst = 'I am also block scoped'; // value can't be changed
    }

    console.log(a);
}

myFunction();
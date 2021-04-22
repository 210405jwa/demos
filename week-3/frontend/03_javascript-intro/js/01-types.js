/*
JavaScript is a dynamically typed language.

Whenever you declare a variable, it can have any type that it wants to.
We can actually have some sort variable, let's it x, and have it store a string
But then later on have it store a number instead

There are several datatypes in JS:

string: unlike in Java, strings in JS are primitives
boolean
number (both whole numbers and decimal values)
undefined
null
object
    - array
function (functions are first-class citizens in JS)
symbol

*/

logType("Josh"); // Why does this work??

function logType(input) {
    console.log(input);
}

logType('Bach');

logType(5);

logType(33.55);

/*
In JavaScript, we have this "feature" called hoisting.

So, for any variable declared with var, the actual declaration of this variable
will be "hoisted" to the top of its scope. So, in this particular case,
any variable declared with var would be hoisted to the top of the
"global scope".

For functions, any function that is declared in the way we saw above
with hello... aka function hello(...) {}

will also be hoisted to the top

*/

logType(a);
var a = 'Something';
logType(a);


// console.log(b); can't do this with let. Let variables are not hoisted
let b;

// same with const
// console.log(c)
const c = 10;

// Let v. const
// let is a variable that you can change the value of
// while const is going to not be able to be changed

// You should pretty much always use let and const instead of var
// let and const were introduced in ES6, which was the MOST significant update
// made to JS

// ES stands for ECMAScript, which is the "standard" for JavaScript.
// So, ECMAScript is the standard, and JavaScript is the language

// Let and const are "block scoped" unlike var, which is function scoped (or global scoped)


// Here is a demonstration of the fact that var declared variables are function scoped
function scopeTest() {
    // var a is being hoisted up to the top of its scope, which is
    // here... the function scope

    if (true) {
        var a = 10;
    }

    console.log(a); // I can actually access a outside of the if block, 
    // even though it was defined in there!
}

scopeTest();

/*

Undefined: any variable declared but has not yet had a value assigned to it

*/
let z;
console.log(z);

/*

Null: use to indicate that there's nothing there

*/
let y = null;
console.log(y);

/*

===== Objects =====

*/

// In JS, curly braces are used for object literals

let obj1 = {};
obj1.name = 'John Doe';
console.log(obj1);

let obj2 = obj1;
obj2.name = 'Jane Doe';

console.log('obj1: ' + JSON.stringify(obj1));

// Every single time you use the {}, you are creating a new object

// variables pointing to an object work pretty much the same as in Java

let person1 = {
    firstName: "Billy", // unlike in JSON, the properties don't have double quotes
    // but otherwise are pretty similar
    // JSON (JavaScript object notation, was inspired by the object literal syntax
    // in JS)
    lastName: "Bob",
    age: 20
};

console.log(person1.firstName);

// const personProperty = prompt('Enter the property you want to retrieve from person1')
const personProperty = 'firstName';
console.log(person1[personProperty]);

person1['yetAnotherProperty'] = 3.1415

console.log(person1);

// Objects in JavaScript can continue to have properties being added to them
// Unlike Java, where you need to change the class blueprint


// JavaScript objects and JSON

// We can convert an object into a JSON string
const person1JSON = JSON.stringify(person1);
console.log(person1JSON);

// I can parse a JSON string into an actual JavaScript object
const person2 = JSON.parse(person1JSON);
console.log(person2);

console.log(person1 == person2);

// == v. ===
// == does what is known as type coercion
console.log(2 == '2'); // true
console.log(2 === '2'); // false

// To get types...
console.log(typeof null); // says object, which is another bug in JS

/*

Arrays: dynamic unlike in Java. In JS, you can add more elements and remove elements
on the fly

*/
const myArr = [1, 2, 3];
console.log(typeof myArr);

// Push and pop: add/remove elements from the end
myArr.push(4); // add an element
console.log(myArr.pop()); // remove the last element added

console.log(myArr);

// Unshift and Shift: add/remove elements from the front
myArr.unshift(0);
console.log(myArr);
console.log(myArr.shift());
console.log(myArr);

/*

The weirdness of JS

*/

console.log(1 / 0); // Is Infinity a number???? Notice we can divide by 0 unlike in Java

console.log(1 / -Infinity); // -0

console.log(0 == -0) // true
console.log(0 === -0); // true

console.log(Infinity / -Infinity);

console.log(typeof (5 + '5')); // string of 55

console.log (5 + + '5'); // number of 10

console.log({} == {}); // false, because 2 different objects
console.log({} === {}); // false, because 2 different objects

console.log(false + true); // 0 + 1 = 1

console.log(true + true); // 1 + 1 = 2;

console.log(null == {}); // false
console.log(null == []); // false
console.log(null == ''); // false
console.log(null == 0); // false


console.log(null == undefined) // true
console.log(null === undefined) // false
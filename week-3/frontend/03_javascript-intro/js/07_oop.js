
// Here we define a function constructor
// It is just a function that will set various properties for our object
function Car(make, model, year) {
    this.make = make;
    this.model = model;
    this.year = year;

    // Don't do this. It's a waste of memory, because every car object will
    // then have its own printCarInfo method.

    // this.printCarInfo = function() {
    //     console.log(`This car is a ${this.year} ${this.make} ${this.model}`)
    // }
}

// Because functions are objects, I can define some methods inside of the prototype property of this function

// If we do this, and define printCarInfo in the prototype property of our function constructor, every object constructed through this function constructor will be able to make use of this function stored in this one location.
Car.prototype = {
    printCarInfo: function() {
        console.log(`This car is a ${this.year} ${this.make} ${this.model}`)
    },
    anotherFunction: function() {
        console.log('This is another function that all cars can access');
    }
}

let car1 = new Car('Honda', 'Accord', 2015); // The new keyword is instantiating a new object, and at the same time is making 'this' for that function (Car) be that new object.

// This syntax with 'new' looks the same as in Java, but it is totally different. We are not instantiating an object from a class, but instead making use of a function that will set properties using 'this' as a reference to the new object

console.log(car1);
car1.printCarInfo();
car1.anotherFunction();

/* ES6 Classes */
// Up above, we saw the usage of a function constructor for our purposes of prototypal inheritance.
// ES6 introduced the "class syntax", which is really just syntactical sugar.
// In other words, classes in JavaScript are not real classes, they are just function constructors under the hood.

// Classes are not hoisted. So, you need to instantiate objects AFTER the declaration
class Person {

    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    greet() {
        console.log(`Hello, ${this.firstName} ${this.lastName}`)
    }

}

// Under the hood, this is what an ES6 class actually is
// function Person(firstName, lastName) {
//     this.firstName = firstName;
//     this.lastName = lastName;
// }

// Person.prototype = {
//     greet: function() {
//         console.log(`Hello, ${this.firstName} ${this.lastName}`)
//     }
// }

let person1 = new Person('John', 'Doe');
person1.greet();

class Rectangle {
    constructor(width, height) {
        this._height = height;
        this._width = width;
    }

    get area() {
        console.log('Invoking the area getter');
        return this._width * this._height;
    }

    set width(width) {
        console.log('Setting width to ' + width)
        this._width = width;
    }

    get width() {
        return this._width;
    }
}

let rectangle1 = new Rectangle(10, 15);
console.log(rectangle1.area);

rectangle1.width = 100;
console.log(rectangle1.area);

/* Inherit from another object without using a function constructor */
let prototypeObj = {
    mySharedProperty: 'This property is shared between all children',
    methodA: function() {
        console.log(this.propertyA);
    },
    methodB: function() {
        console.log(this.propertyB);
    }
}

let childObj = { propertyA: 'abc', propertyB: 'def' };

childObj.__proto__ = prototypeObj;

childObj.methodA();
childObj.methodB();
console.log(childObj.mySharedProperty);

let childObj2 = {};
childObj2.__proto__ = prototypeObj;

childObj2.mySharedProperty = 'Changing this value';
console.log(childObj.mySharedProperty);

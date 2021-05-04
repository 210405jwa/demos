console.log('Hello TypeScript!');

// As we know, there are many basic types in JavaScript
/*
    - string
    - number
    - boolean
    - undefined
    - null
    - any
*/

// Within TypeScript, we can provide types for our variables.
// So, you can think of TypeScript as a strongly typed version
// of JavaScript

// The main purpose of TypeScript is to help us avoid bugs
// regarding the potential misassignment of values to
// certain variables
// TypeScript will yell at us if we try to assign a value
// that is not of the correct type to a variable

// There is no speed or performance benefits of using
// Typescript
//  - it simply makes our lives easier as developers 
// especially for those of us coming from a Java background

// ULTIMATELY, the goal of TypeScript is to catch errors
// in the code editor instead of when the app is running

let a: string;
a = 'Hello';

console.log(a);

// Type Inferencing
let b = 'What type is b?';

// Will this work?
// b = 123; 

// NO! Because, if you declare a variable
// and assign a value of a certain type on the same line,
// it will assume that that variable is of that type only

let c; // c is of type any, which means you can assign anything
// which is pretty much what all variables are in JS
c = 'What type is c?';

// Will this work?
c = 123; // YES!
c = 'Another string';

let d: any = 100;
d = 'A string';
d = 3.1415;

// Another reason to use TypeScript (besides strong typing)

// Because modern code editors are smart, if we have types
// for our variables, objects, etc., we can utilize
// code editor 'intellisense' features to see what methods
// are available

const sentence = "This is a sentence"; // sentence is type String
console.log(sentence.includes('is a'));

let sentence2: any = 'This is a sentence as well';
// sentence2 = 123; // This would break the code below, because includes
// is only a method on a string, not a number
console.log(sentence2.includes("sentence as well"));


/*

Functions in TypeScript

*/

const add = (a: number, b: number) => {
    return a + b;
}

// Type inference works in this case for the return type. Because a is a number
// and b is a number, TypeScript can automatically infer
// that the return type MUST be a number

// If we wanted to add a return type explicitly, we could do so as well
const sub = (a: number, b: number): number => {
    return a - b;
}

/*

Objects

*/

let post = {
    title: 'Some news title here',
    body: 'This is a piece of news... blah blah blah',
}

// Type inferencing works here as well
// so post will have a certain type associated with it

// post in particular has the type: { title: string, body: string }

let post2: { title: string, body: string } = {
    title: 'another post',
    body: 'this is the actual reddit post comment, blah blah blah',
}

/*

Interfaces: instead of having this super long type (imagine we have a lot
    of properties), we can create an interface that defines the type for us,
    more cleanly and reusably 
{ title: string, body: string, ...: ..., ...:...}

*/

interface Post {
    title: string,
    body: string
};

let post3: Post = {
    title: 'title3',
    body: 'lorem ipsum ...'
}

const printPost = (post: Post) => {
    console.log(`Title ${post.title} => Body:${post.body}`);
}

printPost(post3);

/*

    TypeScript classes

*/

class Car {

    // Unlike in JavaScript, in TS we can define various types for our
    // intended properties
    color: string;
    year: number;
    model: string;
    horsepower: number;

    constructor(color: string, year: number, model: string, horsepower: number) {
        this.color = color;
        this.year = year;
        this.model = model;
        this.horsepower = horsepower;
    }

    drive() {
        console.log(`Driving the ${this.year} ${this.color} ${this.model} with ${this.horsepower} HP`);
    }
}

// Classes provide typing as well. So myCar is of the Car type (type inference)
let myCar = new Car('red', 2010, 'Mustang', 300); 
myCar.drive();

/*

    Public and Private

    public: we can access outside of the class
    private: we can only access from within the class, using, for example, methods

*/

class Person {

    private name: string;

    constructor(name: string) {
        this.name = name;
    }

    getName() {
        return this.name;
    }

}

let p1 = new Person('John');
console.log(p1.getName());


// We may also run into this interesting syntax here, which is a shortcut for us
class Pirate {

    constructor(private name: string, public role: string) {
    }

    getName() {
        return this.name;
    }

    getRole() {
        return this.role;
    }

}

let pirate = new Pirate('Blackbeard', 'Captain');
console.log(pirate.role);
console.log(pirate.getName());
console.log(pirate.getRole());

/*

    Decorators are something you will see all the time in Angular
    It looks like annotations in Java, but they behave completely differently

    This can actually be a really complex topic, but we can have a really simple example

    Decorator: a function that executes whenever our class is utilized

*/

const Component = (target: any) => {
    console.log(target);
};

@Component
class Ship {

    constructor(public name: string) {
    }

}

// [class Ship] is being printed out from the decorator function being invoked
// The decorator gets invoked during the first "scan" of the TypeScript code

// So if I do a new Ship here, we should not expect to see another printout again
const ship1 = new Ship('Queen Anne\'s Revenge');

/*

    Strict mode in TypeScript: strict mode prevents 
        - having undefined values for typed variables
        - parameters with no explicitly defined type

*/

/*

    Classes + Interfaces

    We can combine interfaces with classes by using "implements"

*/

interface Driveable {
    speed: number;
    drive(): void
}

class Bicycle implements Driveable {

    constructor(public speed: number) {
    }

    drive() {
        console.log("Riding the bicycle");
    }

    brake() {
        this.speed = 0;
        console.log("Braked to a stop");
    }
}

/*

    Class generics

*/
class MyWrapper<TypeOfProperty> {

    constructor(public value: TypeOfProperty) {
    }

}

let numberWrapper = new MyWrapper<number>(10);
console.log(numberWrapper.value)

let stringWrapper = new MyWrapper<string>('a string');
console.log(stringWrapper.value.includes('a '));

/*

    Function generics

*/

const myFunction = <T>(value: T): T[] => {
    return [value];
}

console.log(myFunction<number>(10));

let myStringArray: string[] = myFunction<string>('a string');
myStringArray.push('abc');
console.log(myStringArray);

let obj1 = {
    firstName: 'John', 
    lastName: 'Doe',
    greet: function(greetWord, endingPunctuation) {
        console.log(`${greetWord}, ${this.firstName} ${this.lastName}${endingPunctuation}`);
    }
}

let obj2 = {
    firstName: 'Jane', 
    lastName: 'Doe'
}

// obj2.greet = obj1.greet;

// I can "borrow" methods that exist in other objects, without having to assign that function to a property in my own object (obj2)

// Call: Allows us to borrow a method from another object
// Apply: does the same thing, but we can pass in an array of parameters
obj1.greet.call(obj2, 'Hey', '!'); // use obj2 as the 'this' variable
// the first argument is the object, while any subsequent arguments are the parameters for that method (greet)
let parameters = ['Hey', '!'];
obj1.greet.apply(obj2, parameters);

// Bind: allows us to "bind" to the function a particular "this"
let greet = obj1.greet.bind(obj2);
// Now I can invoke this greet function without having to do obj2.greet()
// and still be able to have 'this' be 'obj2'
greet('Hey', '!');
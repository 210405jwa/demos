"use strict";

let obj1 = {
    firstName: 'John',
    lastName: 'Doe',
    greet: () => {
        console.log(this);
        console.log(`Hello, ${this.firstName} ${this.lastName}`);
    }
}

obj1.greet(); // we print out Hello, undefined undefined, which is something we might not have expected

// arrow functions defined within the global execution context will have 'this' be the window object

let obj2 = {
    firstName: 'John',
    lastName: 'Doe',
    greet: function() {
        let x = () => {
            console.log(`Hello, ${this.firstName} ${this.lastName}`); // the 'this' inside of here, is the same as the this
            // of the greet function(), which will in turn depend on what object is calling it
        };

        let y = function() {
            console.log(`Hello, ${this.firstName} ${this.lastName}`);
        }

        x(); // for the arrow function, it will use the same this as the parent (greet function)
        //y(); // since we're calling the function y that does not belong to an object in this case, the 'this' will be undefined
    }
}

obj2.greet();
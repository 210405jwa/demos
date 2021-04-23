
// The real way Java does prototypal inheritance

// function Calculator() {
//     this.calculatorOn = false;
// };

// Calculator.prototype.turnOn = function() {
//     this.calculatorOn = true;
// }

// Calculator.prototype.turnOff = function() {
//     this.calculatorOff = false;
// }

// Calculator.prototype.add = function(a, b) {
//     if (this.calculatorOn) {
//         return a + b;
//     } else {
//         throw new Error("calculator is off");
//     } 
// };

// Calculator.prototype.subtract = function(a, b) {
//     if (this.calculatorOn) {
//         return a - b;
//     } else {
//         throw new Error("calculator is off");
//     } 
// };


// Syntactical Sugar
class Calculator {
    constructor() {
        this.calculatorOn = false;
    }

    turnOn() {
        this.calculatorOn = true;
    }

    turnOff() {
        this.calculatorOn = false;
    }

    add(a, b) {
        if (this.calculatorOn) {
            return a + b;
        } else {
            throw new Error("calculator is off");
        } 
    }

    subtract(a, b) {
        if (this.calculatorOn) {
            return a - b;
        } else {
            throw new Error("calculator is off");
        } 
    }
}
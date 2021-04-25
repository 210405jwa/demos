/*

As we have already seen, JavaScript has a lot of type coercion features 
(such as using == as opposed to === for comparison)

There is is this idea of coercing boolean values into numbers (true -> 1 or false -> 0)

We also have the other way around, which is probably the most useful concept, which is treating other values as booleans

*/

function checkTruthy(input) {
    console.log(`input = ${input}, and the type is ${typeof(input)}
    and the truthy/falsey value is ${!!input}`);
}

checkTruthy(true);

// for numbers, only the value 0 is falsey. Every other number is truthy
checkTruthy(2);
checkTruthy(0);
checkTruthy(-1);

checkTruthy(NaN); // falsey
checkTruthy(undefined); // falsey
checkTruthy(Infinity); // truthy
checkTruthy(null); // falsey
checkTruthy(''); // falsey

// just remember 0, '', undefined, null, NaN are falsy
let name;
name = "Bill";
if (name) {
    console.log("My name is: " + name);
} else {
    console.log("No name defined");
}
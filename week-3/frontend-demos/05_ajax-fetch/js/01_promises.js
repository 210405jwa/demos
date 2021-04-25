/*
    The Promise object represents the eventual completion (or failure) of an asynchronous operation and its resulting value.
*/

function fakeFetch() {
    let myPromise = new Promise((resolve, reject) => {

        // Pretend I am the fetch API... and doing some sort of HTTP operations
        // In some other thread in the browser
    
        // Once I receive the data...
        // I will resolve the promise, by supplying the data.
        let result = Math.floor(Math.random() * 9) + 1;
    
        if (result <= 4) {
            resolve(result);
        } else {
            reject('Failed to retrieve data');
        }
    
    });

    return myPromise;
}


// Pretend the above promise doesn't exist in MY OWN code. Instead it is part of the web APIs running in the browser. We don't have control over those.
// But we do need to make use of the promise being returned by something.

// So, we really don't need to write our own promises. We just need to understand how to utilize the promises that other APIs return, such as the Fetch API.
// fakeFetch().then((data) => {
//     console.log('result of the promise resolving: ' + data);
// })
// .catch((err) => {
//     console.log(err);
// });

// Async/await
// Promises were introduced in ES6, but in ES8, async/await made dealing with promises even easier

// We can define async functions
// There is the await keyword that we can use to retrieve the data from a promise
// in a more concise manner than .then((data) => console.log(data))

async function myAsyncFunction() {

    try {
        let result = await fakeFetch();
        console.log(result);
    } catch(err) {
        console.log(err);
    }

}

myAsyncFunction();

console.log('This comes before the output of the async function');

// Basically async/await allows us to instead of using .then() and .catch(), define some sort of async function and use await inside.

// YOU CANNOT use await outside of async functions.
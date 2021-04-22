"use strict";
let URL = "https://pokeapi.co/api/v2/pokemon/";
let button = document.querySelector('#button');
let clearButton = document.querySelector('#cleardata');

clearButton.addEventListener('click', clearData);
button.addEventListener('click', retrieveDataWithFetch);


/*
    Fetch API (modern way)
*/
function retrieveDataWithFetch() {
    let id = document.querySelector('#pokemonId').value;
    fetch(URL + id, {
        method: 'GET',
        credentials: 'include'
    })
    .then((data) => {
        return data.json();

        // then should return a promise, always
    })
    .then((response) => {
        populateData(response);
    });
    // Fetch returns what is known as a promise. You can think of a promise as something
    // that should happen in the future
}



/*
    AJAX (Asynchronous JavaScript w/ XML)
*/
function retrieveDataWithAJAX() {
    let id = document.querySelector('#pokemonId').value;

    // 4 steps to making an AJAX call
    // Step 1: Create an XMLHttpRequest object
    let xhttp = new XMLHttpRequest();

    // Step 2: Set a callback function for the readystatechange event
    xhttp.addEventListener('readystatechange', receiveData);

    // Step 3: Open the request
    xhttp.open('GET', URL + id);

    // Step 4: Send the request
    xhttp.send();

    function receiveData() {
        /*
            There are different "ready states" of an XMLHttpRequest object

            0: UNSENT
            1: OPENED
            2: HEADERS RECEIVED
            3: LOADING
            4: DONE
        */
       if (xhttp.readyState === 4) {
           if (xhttp.status === 200) {
               let response = xhttp.responseText;
               response = JSON.parse(response); // convert from JSON to a JS object
               populateData(response); // call another function that will manipulate
               // the DOM with this data
           }
       }
    }
}

function populateData(response) {
    let tbody = document.querySelector('#data table tbody');
    let tr = document.createElement('tr');

    let id = response.id;
    let name = response.name;
    let imageUrl = response.sprites.front_default;

    let idTd = document.createElement('td');
    idTd.innerHTML = id;

    let nameTd = document.createElement('td');
    nameTd.innerHTML = name;

    let imageTd = document.createElement('td');
    imageTd.innerHTML = `<img src="${imageUrl}">`;

    tr.appendChild(idTd);
    tr.appendChild(nameTd);
    tr.appendChild(imageTd);

    tbody.appendChild(tr);
}

function clearData() {
    let tbody = document.querySelector('#data table tbody');
    tbody.innerHTML = '';
}

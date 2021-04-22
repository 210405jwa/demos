/* Basic Demonstration of how the callback queue works w/ the event loop and the
various web apis that are part of our browser */

// This would be an exampe of Async JS
// setTimeout(() => {
//     console.log('5 seconds later');
// }, 5000);

// setInterval(() => {
//     console.log('This one will execute every second');
// }, 1000);

// console.log('Hi there!'); // This will execute before any of the callback functions
// Because the event loop must wait for all of our own code to execute first


/* Setting EventListeners is a more useful aspect of asynchronous JavaScript */
// document.getElementById('button').addEventListener('click', (event) => {
//     console.log(event);
//     console.log('Button clicked!');
// });

let cap = false;
let button = document.getElementById('button');

// window.onload = function() {
//     button.innerHTML = 'Capture?';
//     addEventListenersToDivs();
//     button.onclick = switchCapture;
// };

function switchCapture() {
    removeEventListenersFromDivs();
    if (!cap) {
        cap = !cap;
        console.log('switched to capture');
        button.textContent = 'Bubble?';
    } else {
        cap = !cap;
        console.log('switched to bubble');
        button.textContent = 'Capture?';
    }
    addEventListenersToDivs();
}

let a = document.getElementById('A');
let b = document.getElementById('B');
let c = document.getElementById('C');
let d = document.getElementById('D');
let e = document.getElementById('E');

function addEventListenersToDivs() {
    a.addEventListener('mouseover', select, cap);
    a.addEventListener('mouseout', unselect, cap);
    b.addEventListener('mouseover', select, cap);
    b.addEventListener('mouseout', unselect, cap);
    c.addEventListener('mouseover', select, cap);
    c.addEventListener('mouseout', unselect, cap);
    d.addEventListener('mouseover', select, cap);
    d.addEventListener('mouseout', unselect, cap);
    e.addEventListener('mouseover', select, cap);
    e.addEventListener('mouseout', unselect, cap);
}

function removeEventListenersFromDivs() {
    a.removeEventListener('mouseover', select, cap);
    a.removeEventListener('mouseover', unselect, cap);
    b.removeEventListener('mouseover', select, cap);
    b.removeEventListener('mouseover', unselect, cap);
    c.removeEventListener('mouseover', select, cap);
    c.removeEventListener('mouseout', unselect, cap);
    d.removeEventListener('mouseover', select, cap);
    d.removeEventListener('mouseout', unselect, cap);
    e.removeEventListener('mouseover', select, cap);
    e.removeEventListener('mouseout', unselect, cap);
}

function select(event) {
    event.stopPropagation(); // stopPropagation will prevent an event from propagating further
    // so if we have elements in the bubbling phase, and we stop propagation,
    // we can have the event only apply to that particular event listener and none
    // of the parents
    event.currentTarget.style.backgroundColor = 'Purple';
    console.log(event.currentTarget.id);
}

function unselect(event) {
    event.currentTarget.style.backgroundColor = 'Orange';
}

/*
    DOM Manipulation
*/

let elementsWithClassBtn = document.getElementsByClassName('btn');
console.log(elementsWithClassBtn);

for(let i = 0; i < elementsWithClassBtn.length; i++) {
    elementsWithClassBtn[i].innerHTML = 'Button';
}

let spanElements = document.getElementsByTagName('span');
console.log(spanElements[0].textContent);

let tableSection = document.getElementById('table');

// Searching for the first occurence of the button selector inside of our 
// tableSectionButton
let tableSectionButton = tableSection.querySelector('button');
console.log(tableSectionButton.textContent);
tableSectionButton.innerHTML = 'Create table';

tableSectionButton.addEventListener('click', createTable);

function createTable() {
    tableSectionButton.removeEventListener('click', createTable);

    let tableDiv = document.querySelector('#tableDiv');

    let table = tableDiv.querySelector('table');
    let thead = table.querySelector('thead');
    let tbody = table.querySelector('tbody');

    let rows = (Math.floor(Math.random() * 9)) + 1;
    let cols = (Math.floor(Math.random() * 9)) + 1;
    for (let i = 0; i < rows; i++) {
        let tr = document.createElement('tr');
        for (let j = 0; j < cols; j++) {
            let td;
            if (i === 0) td = document.createElement('th');
            else td = document.createElement('td');
            td.innerHTML = '1';
            tr.appendChild(td);
        }
        if (i === 0) thead.appendChild(tr);
        else tbody.appendChild(tr);
    }


    tableDiv.appendChild(table);

    tableSectionButton.innerHTML = 'Remove table';
    tableSectionButton.addEventListener('click', removeTable);
}

function removeTable() {
    tableSectionButton.addEventListener('click', createTable);
    tableSectionButton.innerHTML = 'Create table';

    let thead = document.querySelector('#tableDiv thead');
    let tbody = document.querySelector('#tableDiv tbody');
    thead.innerHTML = '';
    tbody.innerHTML = '';
}
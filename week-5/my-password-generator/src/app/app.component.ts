import { typeWithParameters } from '@angular/compiler/src/render3/util';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  passwordLength: number = 0;
  passwordOutput: string = '';

  useLetters: boolean = false;
  useSpecialCharacters: boolean = false;
  useNumbers: boolean = false;

  tableData: { id: number, firstName: string, lastName: string }[]
    = [{id:1, firstName:'Bach', lastName: 'Tran'}, {id:2, firstName:'Biren', lastName: 'Sarvaiya'}]
  constructor() {
  }

  ngOnChanges() {
    console.log('something changed');
  }

  onButtonClick() {
    this.generatePassword();
    console.log(this.passwordOutput);
  }

  onInputChange(event: { target: HTMLInputElement }) {
    this.passwordLength = Number(event.target.value);
  }

  onUseLetterChange() {
    this.useLetters = !this.useLetters;
  }

  onUseSpecialCharacterChange() {
    this.useSpecialCharacters = !this.useSpecialCharacters;
  }

  onUseNumberChange() {
    this.useNumbers = !this.useNumbers;
  }

  generatePassword() {
    this.clearOutput();
    let possibleLetters = 'abcdefghijklmnopqrstuvwxyz'
    possibleLetters += possibleLetters.toUpperCase();

    let possibleSpecialChars = '!@#$%^&*()';
    let possibleDigits = '0123456789';

    let charactersToUse = '';

    if (this.useLetters) {
      charactersToUse += possibleLetters;
    }

    if (this.useSpecialCharacters) {
      charactersToUse += possibleSpecialChars;
    }

    if (this.useNumbers) {
      charactersToUse += possibleDigits;
    }

    // For now, just focus on generating a random string of letters
    for (let i = 0; i < this.passwordLength; i++) {
      let index = Math.floor(Math.random() * charactersToUse.length);
      this.passwordOutput += charactersToUse.charAt(index);
    }
  }

  clearOutput() {
    this.passwordOutput = '';
  }

}

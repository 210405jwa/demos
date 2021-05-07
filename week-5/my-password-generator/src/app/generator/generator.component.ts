import { Component, DoCheck, Input, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-generator',
  templateUrl: './generator.component.html',
  styleUrls: ['./generator.component.css']
})
export class GeneratorComponent implements OnInit, OnChanges, DoCheck, OnDestroy {

  // Input Decorator
  // This is an input property
  @Input()
  length: number = 0;

  passwordOutput: string = '';

  useLetters: boolean = false;
  useSpecialCharacters: boolean = false;
  useNumbers: boolean = false;

  /*
    Lifecycle Hooks
  */
  constructor() {
    console.log('constructor invoked');
  }

  ngOnChanges(changes: SimpleChanges) {
    console.log('ngOnChanges invoked');
    if (changes.length) {
      console.log('Previous value was ' + changes.length.previousValue);
      console.log('Current value is ' + changes.length.currentValue);
    }
  }

  ngOnInit(): void {
    console.log('ngOnInit invoked');
  }

  ngDoCheck(): void {
    console.log('ngDoCheck invoked');
  }

  ngOnDestroy(): void {
    console.log('Component is about to be destroyed');
  }

  /*
    Component methods
  */
  shouldButtonBeDisabled(): boolean {
    return !(this.useLetters || this.useSpecialCharacters || this.useNumbers) || !this.length
  }

  onButtonClick() {
    this.generatePassword();
    console.log(this.passwordOutput);
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
    for (let i = 0; i < this.length; i++) {
      let index = Math.floor(Math.random() * charactersToUse.length);
      this.passwordOutput += charactersToUse.charAt(index);
    }
  }

  clearOutput() {
    this.passwordOutput = '';
  }

}

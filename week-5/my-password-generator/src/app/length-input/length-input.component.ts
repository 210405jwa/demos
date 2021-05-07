import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-length-input',
  templateUrl: './length-input.component.html',
  styleUrls: ['./length-input.component.css']
})
export class LengthInputComponent implements OnInit {

  @Output()
  inputChange = new EventEmitter<number>();

  @Output()
  toggle = new EventEmitter<void>();

  constructor() { }

  ngOnInit(): void {
  }

  onInputChange(event: { target: HTMLInputElement }) {
    this.inputChange.emit(Number(event.target.value));
  }

  onToggleButtonClick() {
    this.toggle.emit();
  }

}

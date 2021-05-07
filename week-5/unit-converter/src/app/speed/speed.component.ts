import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-speed',
  templateUrl: './speed.component.html',
  styleUrls: ['./speed.component.css']
})
export class SpeedComponent implements OnInit {

  milesPerHour: number;
  kilometersPerHour: number;

  constructor() { }

  ngOnInit(): void {
  }

}

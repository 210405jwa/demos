import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ngforexample',
  templateUrl: './ngforexample.component.html',
  styleUrls: ['./ngforexample.component.css']
})
export class NgforexampleComponent implements OnInit {

  tableData: { id: number, firstName: string, lastName: string }[]
    = [{id:1, firstName:'Bach', lastName: 'Tran'}, {id:2, firstName:'Biren', lastName: 'Sarvaiya'}]

  constructor() { }

  ngOnInit(): void {
  }

}

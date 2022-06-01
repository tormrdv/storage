import { Component, OnInit } from '@angular/core';

import { items } from 'src/app/Item';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  items = items;
  
  constructor() { }

  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/models/item.model';
import { items } from 'src/app/Item';
import { ItemService } from 'src/app/services/item.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  //items = items;
  
  items: Item[];
  constructor(
    private itemService: ItemService,
    private router: Router,
    ) { }


  ngOnInit(): void {
    this.getItems()
  }

  private getItems() {
    this.itemService.getItem().subscribe( data => {
      this.items = data;
    })
  }

  

  deleteItem(id: number) {
    this.itemService.deleteItem(id).subscribe( data=> {
      console.log(data)
      this.getItems()
    })
  }

}

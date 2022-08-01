import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/models/item.model';
import { ItemService } from 'src/app/services/item.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  displayedColumns: string[] = ['name', 'weight', 'colour', 'value', 'delete'];
  items: Item[];
  constructor(
    private itemService: ItemService,
    private router: Router,
    ) { }

    selected = ""
    //todo import storages and sort out the nesting view
    storages = [
      {name: 'Box 1', type: '1'},
      {name: 'Warehouse 1', type: '2'}

    ]

  ngOnInit(): void {
    this.getItems()
  }

  private getItems() {
    this.itemService.getItem().subscribe( data => {
      this.items = data;
    })
  }

  deleteItem(id: number) {
    /*const Data = this.itemService.deleteItem(id).pipe(data => {
      if (Data == null) return throwError("null data")
      return Data
    })

    Data.subscribe(
      data => console.log(data)
    )
    
    /*try{
      this.itemService.deleteItem(id).subscribe(
        (data: any) => {
          if (data == null)
        }
      )
    }
    catch (e){
      if (typeof e === "string"){
        e.toUpperCase()
        console.log(e)
      } else if (e instanceof Error){
        console.log(e)
      } else {
        console.log(e)
      }
    }
    finally{
      this.getItems()
    }
    */
    this.itemService.deleteItem(id).subscribe( data=> {
      console.log(data)
      this.getItems()
    })
  }




}

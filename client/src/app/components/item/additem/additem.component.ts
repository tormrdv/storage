import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Item } from 'src/app/models/item.model';
import { ItemService } from 'src/app/services/item.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-additem',
  templateUrl: './additem.component.html',
  styleUrls: ['../../../app.component.css']
})
export class AdditemComponent implements OnInit{

  item: Item = new Item()
  constructor(
    private itemService: ItemService,
    private router: Router,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
  }
  
  addItemForm = this.fb.group({
    name: [null, Validators.required],
    serialNumber: null,
    weight: [null, Validators.required],
    value: [null, Validators.required],
    colour: [null, Validators.required],
    fileName: null,
    storage: null
    
  });

  hasSerialNumber = false;

  storages = [
    
    {name: 'Box 1', type: '1'},
    
  ];

  saveItem() {
    this.item = this.addItemForm.value  
    /*this.item.storage = this.addItemForm.get('storage').value*/

    this.itemService.addItem(this.item).subscribe( data=>{
      console.log(data)
      alert('Item Added!')
      this.goHome()
    },
    error => console.log(error))
  }

  goHome() {
    this.router.navigate(['/home'])
  }

  onSubmit(): void {
    if (this.addItemForm.valid){
      this.saveItem()
    } 
  }
}

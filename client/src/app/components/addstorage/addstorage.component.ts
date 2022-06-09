import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-addstorage',
  templateUrl: './addstorage.component.html',
  styleUrls: ['../../app.component.css']
})
export class AddstorageComponent {
  addStorageForm = this.fb.group({
    name: [null, Validators.required],
    code: [null, Validators.required],
    parent: null
  });

  hasParent = false;

  storages = [
    {name: 'Box', type: 1},
    
  ];

  constructor(private fb: FormBuilder) {}

  onSubmit(): void {
    alert('Thanks!');
  }
}

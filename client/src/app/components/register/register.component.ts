import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['../../app.component.css']
})
export class RegisterComponent {

  //formcontrol

  registerForm = this.fb.group({
    email: [null, Validators.required],
    password: [null, Validators.required],
    confirmPw: [null, Validators.required],
    username: [null, Validators.required],
  });
  

  constructor(private fb: FormBuilder) {}

  onSubmit(): void {
    alert('Thanks!');
  }
}

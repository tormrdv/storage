import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdditemComponent } from './components/item/additem/additem.component';
import { AddstorageComponent } from './components/addstorage/addstorage.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
  {path: "", component: LoginComponent },
  {path: "home", component: HomeComponent },
  {path: "register", component: RegisterComponent},
  {path: "storage/add", component: AddstorageComponent},
  {path: "item/add", component: AdditemComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
  
})
export class AppRoutingModule { }

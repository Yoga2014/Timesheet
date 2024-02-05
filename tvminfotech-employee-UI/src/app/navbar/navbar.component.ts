import { Component } from '@angular/core';
import { SignupService } from '../api/signup.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

   constructor( private AuthService:SignupService){}


  logoutUser(){
   this.AuthService.signOut();
  }
}

import { Component } from '@angular/core';
import { Router } from '@angular/router';
import 'jquery';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
images: any;

constructor(private route:Router,private emp: EmployeeService){

}
navigateToNavbar(){
  this.emp.loginClick = true;
  this.route.navigate(['/home'])
}
}

import { Component } from '@angular/core';
import { Router } from '@angular/router';
import 'jquery';
import { EmployeeService } from '../employee.service';
import { LoginService } from '../api/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
images: any;
constructor(private route:Router,private emp: EmployeeService,private loginService:LoginService){

}
navigateToNavbar(){
  //this.emp.loginClick = true;
  let params = {
    "email": "yogarani.2014.prabhu@gmail.com",
    "password": "Test@123#"
  };
  this.loginService.authLogin(params).subscribe((x:any)=>{
    localStorage.setItem('token',x.token);
    localStorage.setItem('expiresIn',x.expiresIn);
  });
  this.route.navigate(['/home'])
}
}

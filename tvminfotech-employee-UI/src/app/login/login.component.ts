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
isvalid:boolean=true
newEmployee: any = {
  id: 0,
  name: '',
  position: '',
  address: {
    street: '',
    city: '',
    state: '',
    zip: ''
  },
  photo: '',
  details: ''
};
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

signUpClick(){
   this.isvalid=false
}
ngOnInit(): void {
    
}
signup() {
  this.emp.addEmployee(this.newEmployee.value).subscribe((res:any) => {
    // console.log(this.newEmployee.value);
   
    console.log("Registration successfull")
    window.alert("Registration successfull")
  });
  this.isvalid=true
}

navigateToLogin() {
  // this.route.navigate(['/login']);
}

}

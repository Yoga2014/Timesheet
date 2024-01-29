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

constructor(private route:Router,private emp: EmployeeService){

}
navigateToNavbar(){
  this.emp.loginClick = true;
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

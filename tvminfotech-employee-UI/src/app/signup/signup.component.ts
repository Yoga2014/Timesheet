import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { SignupService } from '../api/signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{
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
  constructor(private router: Router, private employeeService: EmployeeService,private signUpService:SignupService) {}
  
  ngOnInit(): void {
    
  }
  signup() {
    let params={
      "email": "yogarani.2014.prabhu@gmail.com",
      "password": "Test@123#",
      "fullName": "Yoga B"
    };
    this.signUpService.authSignUp(params).subscribe((x:any)=>{
      alert("Sign Up Successful");
    })
    this.employeeService.addEmployee(this.newEmployee.value).subscribe((res:any) => {
      // console.log(this.newEmployee.value);
     
      this.router.navigate(['/login']);
      console.log("Registration successfull")
      window.alert("Registration successfull")
    });
  }

  navigateToLogin() {
    this.router.navigate(['/login']);
  }

}

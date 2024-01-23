import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';

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
  constructor(private router: Router, private employeeService: EmployeeService) {}
  
  ngOnInit(): void {
    
  }
  signup() {
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

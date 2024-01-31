import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { SignupService } from '../api/signup.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{

  registerForm:FormGroup |any;


constructor(private route:Router,private formBuilder:FormBuilder,
  public signupService:SignupService){}

ngOnInit(): void {
   
    this.registerForm = this.formBuilder.group({
      fname:['',[Validators.required]],
      lname:['',[Validators.required]],
      password:['',[Validators.required]],
      street:['',[Validators.required]],
      city:['',[Validators.required]],
      state:['',[Validators.required]],
      zip:['',[Validators.required]],
      photo:['',[Validators.required]],
      details:['',[Validators.required]]
    })
}

signup() {
  debugger
  // if(this.registerForm.valid){
  //   this.formBuilder=this.registerForm.value
  //   console.log(this.registerForm.value)
  //   this.signupService.authSignUp(this.registerForm.value)
  //   console.log("sig", this.signupService)
  // }
  // this.isvalid=true
  debugger;
  const formData = this.registerForm.value;
  console.log('Form Data:', formData);

  if (this.registerForm.valid) {
    this.signupService.signUp(formData).subscribe(
      (res) => {
        console.log('Signup Response:', res);
        alert('SignUp Successful');
        this.route.navigate(['/login']);
      },
      (error) => {
        console.error('Signup Error:', error);
        alert('Error during signup');
      }
    );
  }
   
  }
}
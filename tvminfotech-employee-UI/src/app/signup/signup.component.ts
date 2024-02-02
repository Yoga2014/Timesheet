import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SignupService } from '../api/signup.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  registerForm: FormGroup | any;


  constructor(private route: Router, private formBuilder: FormBuilder,
    public signupService: SignupService) { }

  ngOnInit(): void {

    this.registerForm = this.formBuilder.group({
      fullName: ['', [Validators.required]],
      email: ['', [Validators.required]],
      password: ['', [Validators.required]],
      // street:['',[Validators.required]],
      // city:['',[Validators.required]],
      // state:['',[Validators.required]],
      // zip:['',[Validators.required]],
      // photo:['',[Validators.required]],
      // details:['',[Validators.required]]
    })
  }

  signup() {

    if (this.registerForm.valid) {
      this.signupService.signUp(this.registerForm.value).subscribe(
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
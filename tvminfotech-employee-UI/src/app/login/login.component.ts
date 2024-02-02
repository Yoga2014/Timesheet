import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import 'jquery';
import { LoginService } from '../api/login.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SignupService } from '../api/signup.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
images: any;
isvalid:boolean=true
loginForm:FormGroup | any;


constructor(private route:Router,private formBuilder:FormBuilder,
  public loginService:LoginService,public signupService:SignupService){}

ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email:['',[Validators.required]],
      password:['',[Validators.required]]
    });  
  
}

navigateToNavbar(){
 
  if(this.loginForm.valid){
    const formdata = this.loginForm.value;

    this.signupService.signIn(formdata).subscribe(
      (res:any)=>{
        alert('Login Successful')
        console.log(res)
        this.signupService.storeToken(res.token);
      
        this.route.navigate(['./home'])
      },
      (error)=>{
        alert('Login error')
      }
    )
  }
}

signUpClick(){ 
   this.route.navigate(['./signup'])
}

}

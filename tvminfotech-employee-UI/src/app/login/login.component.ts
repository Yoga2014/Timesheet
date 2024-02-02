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
  //this.emp.loginClick = true;
  // let params = {
  //   "email": "yogarani.2014.prabhu@gmail.com",
  //   "password": "Test@123#"
  // };
  // localStorage.setItem('some','Akash')
  // this.loginService.authLogin(params).subscribe((x:any)=>{
  //   localStorage.setItem('token',x.token);
  //   localStorage.setItem('expiresIn',x.expiresIn);
  // });
  // this.route.navigate(['/home'])
  debugger
  if(this.loginForm.valid){
    const formdata = this.loginForm.value;

    this.signupService.signIn(formdata).subscribe(
      (res:any)=>{
        alert('Login Successful')
        console.log(res)
      
        this.route.navigate(['./home'])
      },
      (error)=>{
        alert('Login error')
      }
    )
  }
}

signUpClick(){
  debugger
   this.route.navigate(['./signup'])
}
data:any
click(){
  debugger
  this.signupService.get().subscribe((res)=>
  this.data = res
  )
  console.log('vgh', this.data)
}

navigateToLogin() {
  // this.route.navigate(['/login']);
}

}

import { Component } from '@angular/core';
import { EmployeeService } from './employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'tvm';
  navView = false;
  href = '';
  constructor(private emp: EmployeeService,
    private router: Router){ }

 ngDoCheck(){
  this.href = this.router.url;
  console.log('href',this.href);
  if(this.href == '/login' || this.href == '/signup' || this.href == "/"){
    this.navView = false
  }else{
    
    this.navView = this.emp.loginClick;

  }
 }
}
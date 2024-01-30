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
  navView = true;
  href = '';
  constructor(private emp: EmployeeService,
    private router: Router) { }

  ngDoCheck() {
    this.href = this.router.url;
    if (this.href === '/') {
      this.navView = false;
    } else {
      this.navView = true
    }
  }
}
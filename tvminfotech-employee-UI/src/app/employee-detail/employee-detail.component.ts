import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {
  employees: any[] = [];
  selectedEmployee: any | null = null;
  
constructor(private employeeService:EmployeeService){}

  ngOnInit(): void {
    
    this.employeeService.getEmployees().subscribe((res : any)=>{
      this.employees = res;
      console.log('Fetched employees:', res);
    })

  }
  
  selectEmployee(employee: any): void {
    this.selectedEmployee = employee;
    console.log('Selected employee:', employee);
  }

}

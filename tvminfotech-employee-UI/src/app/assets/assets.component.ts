import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-assets',
  templateUrl: './assets.component.html',
  styleUrls: ['./assets.component.css']
})
export class AssetsComponent implements OnInit{
  
  employees: any[] = [];
  selectedEmployee: any = {};
  assetDetails: any[] = [];

  constructor(private employeeService:EmployeeService) {
  
  }

  ngOnInit(): void {
    
    this.employeeService.getassets().subscribe((res:any)=>{
      this.assetDetails=res
      console.log('Fetched assets:', res);
    })
  }
  selectEmployee(employee: any): void {
    this.selectedEmployee = employee;
    console.log('Selected employee:', employee);
  }



}





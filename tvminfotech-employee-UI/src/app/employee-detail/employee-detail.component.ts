import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { EmployeePopupComponent } from '../employee-popup/employee-popup.component';
import { SharedService } from '../shared.service';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {
  employees: any[] = [];
  selectedEmployee: any | null = null;
  
constructor(private employeeService:EmployeeService,public dialog: MatDialog,private sharedService: SharedService){}

  ngOnInit(): void {
    this.getcall()
    this.subscribeToEmployeeData();
   
  }
  subscribeToEmployeeData(): void {
    this.sharedService.getEmployeeData().subscribe((data:any) => {
      if (data) {
        this.employees.push(data); // Add the new employee to the list
      }
    });
  }
  
  
  selectEmployee(employee: any): void {
    this.selectedEmployee = employee;
    console.log('Selected employee:', employee);
  }
  getcall(){this.employeeService.getEmployees().subscribe((res : any)=>{
    this.employees = res;
    console.log('Fetched employees:', res);
  })}

  openEmployeePopup(): void {
    const dialogRef = this.dialog.open(EmployeePopupComponent, {
      width: '400px', 
      // Set the width as needed
      // maxWidth: '800px', // Set a specific maximum width
      // maxHeight: '100%', // Set a specific maximum heig
    });

    dialogRef.afterClosed().subscribe(() => {
      console.log('The dialog was closed');
    });
  }

}

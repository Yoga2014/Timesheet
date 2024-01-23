import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { AttendanceService } from '../attendance.service';

@Component({
  selector: 'app-attendance',
  templateUrl: './attendance.component.html',
  styleUrls: ['./attendance.component.css']
})
export class AttendanceComponent implements OnInit{
  employees: any = [];
  attendanceData: any[] = [];
  attendanceForm: any 
  
  attendanceOptions: string[] = ['WFH', 'WFO', 'Holiday', 'Leave'];
  
  constructor(
    private employeeService: EmployeeService,
    private attendanceService: AttendanceService,
    private formBuilder: FormBuilder
  ) {}
  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe((res : any)=>{
      this.employees = res;
      console.log('Fetched employees:', res);
      this.loadAttendanceData();
    this.initializeForm();
    })
  }

  loadAttendanceData(): void {
    this.attendanceData = this.attendanceService.getAttendanceData();
    console.log('Attendance Data:', this.attendanceData);
  }

  initializeForm(): void {
    this.attendanceForm = this.formBuilder.group({
      employeeId: [''],
      attendanceType: [''],
    });
  }

  markAttendance(): void {
    const { employeeId, attendanceType } = this.attendanceForm.value;
    if (employeeId && attendanceType) {
      this.attendanceService.markAttendance(employeeId, attendanceType);
      this.loadAttendanceData();
      this.attendanceForm.reset();
    }
  }

}

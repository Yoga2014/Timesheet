import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { AttendanceService } from '../attendance.service';

@Component({
  selector: 'app-attendance',
  templateUrl: './attendance.component.html',
  styleUrls: ['./attendance.component.css']
})
export class AttendanceComponent implements OnInit {
  array: any = [];
  uniqueEmployeeIds = new Set<string>(); // Set to store unique employee IDs
  employees: any = [];
  attendanceData: any[] = [];
  attendanceForm: any;
  attendanceOptions: string[] = ['WFH', 'WFO', 'Holiday', 'Leave'];

  constructor(
    private employeeService: EmployeeService,
    private attendanceService: AttendanceService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe((res) => {
      this.employees = res;
    });

    this.attendanceService.getmethod().subscribe((res: any) => {
      this.array = res;
      // Initialize uniqueEmployeeIds set with existing employee IDs
      this.array.forEach((record: any) => {
        this.uniqueEmployeeIds.add(record.employeeId);
      });
    });

    this.initializeForm();
  }

  initializeForm(): void {
    this.attendanceForm = this.formBuilder.group({
      employeeId: [''],
      attendanceType: [''],
    });
  }

  markAttendance(): void {
    const { employeeId, attendanceType } = this.attendanceForm.value;
    if (employeeId && attendanceType && !this.uniqueEmployeeIds.has(employeeId)) {
      this.attendanceService.postmethod(this.attendanceForm.value).subscribe((response) => {
        console.log('Response from server:', response);

        // Update the local array with the new record
        this.array.push(response);

        // Update the set of unique employee IDs
        this.uniqueEmployeeIds.add(employeeId);

        // Reset the form
        this.attendanceForm.reset();
      });
    }
  }

  markCheckIn(record: any) {
    const currentTime = new Date();
    record.checkIn = currentTime;
   
  }

  checkout(record: any) {
    const currentTime = new Date();
    record.checkOut = currentTime;
    this.calculateTotalLoginTime(record);
  }

  calculateTotalLoginTime(record: any) {
    if (record.checkIn && record.checkOut) {
      const diffMilliseconds = record.checkOut.getTime() - record.checkIn.getTime();
      const totalLoginTime = this.msToTime(diffMilliseconds);
      record.totallogintime = totalLoginTime;
    }
  }

  msToTime(duration: number) {
    const minutes = Math.floor((duration / (1000 * 60)) % 60);
    const hours = Math.floor((duration / (1000 * 60 * 60)) % 24);

    const formattedTime = `${this.pad(hours)}:${this.pad(minutes)}`;
    return formattedTime;
  }

  pad(num: number) {
    return num < 10 ? `0${num}` : num;
  }

  getCurrentDate(): Date {
    return new Date();
  }

  lorh(attendanceType: string): boolean {
    return attendanceType === 'Leave' || attendanceType === 'Holiday';
    
  }
  isLeave(attendanceType: string): boolean {
    return attendanceType === 'Leave';
  }
  
  isHoliday(attendanceType: string): boolean {
    return attendanceType === 'Holiday';
  }
  
}


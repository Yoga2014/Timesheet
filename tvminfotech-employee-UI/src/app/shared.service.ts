import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  constructor() { }
  employeeData: any = null;

  setEmployeeData(data: any): void {
    this.employeeData = data;
  }

  getEmployeeData(): any {
    return this.employeeData;
  }
  
}

import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AttendanceService {

  private attendanceData: any[] = [];

  getAttendanceData(): any[] {
    return this.attendanceData;
  }

  markAttendance(employeeId: number, attendanceType: string): void {
    const existingRecordIndex = this.attendanceData.findIndex(
      (record) => record.employeeId === employeeId && !record.checkOut
    );

    if (existingRecordIndex !== -1) {
    
      this.attendanceData[existingRecordIndex].checkOut = new Date();
      this.attendanceData[existingRecordIndex].attendanceType = attendanceType;
    } else {
      
      const attendanceRecord = {
        employeeId,
        date: new Date().toLocaleDateString(),
        checkIn: new Date(),
        checkOut: null,
        attendanceType,
      };
      this.attendanceData.push(attendanceRecord);
    }
  }
}

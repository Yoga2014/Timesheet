
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AttendanceService {

  private attendanceData: any[] = [];
   constructor(private http:HttpClient){}

   postmethod(data:any){
    return this.http.post('http://localhost:3000/attendance/', data);
  }
  
   getmethod(){
  return this.http.get('http://localhost:3000/attendance');
}

  }
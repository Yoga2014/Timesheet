import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
}) 
export class SignupService {

  baseUrl = "http://localhost:8080/auth";
  constructor(private http:HttpClient) { }

  // authSignUp(params:any){
  //   return this.http.post<any>(this.baseUrl,params);
  // }
  signIn(data:any){
    // const loginData = {email , password};
    return this.http.post(`${this.baseUrl}/signin`, data)
  }
  signUp(data: any) {
    debugger
    const url = `${this.baseUrl}/signup`;
    return this.http.post(url, data).pipe(
      catchError((error) => {
        console.error('Signup Error:', error);
        return throwError('Error during signup');
      })
    );
  }
  
}

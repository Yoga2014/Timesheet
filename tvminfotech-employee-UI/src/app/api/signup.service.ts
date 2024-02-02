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
  get(){
   return this.http.get(`${this.baseUrl}/signup`)
  }
  signIn(data:any){
    // const loginData = {email , password};
    return this.http.post(`${this.baseUrl}/login`, data)
  }
  signUp(data: any) {
    const url = `${this.baseUrl}/signup`;
    return this.http.post(url, data).pipe(
      catchError((error) => {
        console.error('Signup Error:', error);
        return throwError('Error during signup');
      })
    );
  }
  
}

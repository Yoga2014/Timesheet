import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Route, Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
}) 
export class SignupService {

  baseUrl = "http://localhost:8080/auth";
  constructor(private http:HttpClient, private routers:Router) { }

  signIn(data:any){
    return this.http.post(`${this.baseUrl}/login`, data)
  }

  signUp(data: any) {
    const url = `${this.baseUrl}/signup`;
    return this.http.post(url, data).pipe(
      catchError((error) => {
        return throwError('Error during signup');
      })
    );
  }
  
  storeToken(tokenValue: string){
    localStorage.setItem('token',tokenValue)
  }

  getToken(){
    return localStorage.getItem('token')
  }

  isloggedIn(): boolean{
    return !! localStorage.getItem('token')
  }

  signOut(){
    localStorage.clear();
    this.routers.navigate(['/login'])

  }

}

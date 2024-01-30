import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  baseUrl = "http://localhost:8080/auth/signup";
  constructor(private http:HttpClient) { }

  authSignUp(params:any){
    return this.http.post<any>(this.baseUrl,params);
  }
}

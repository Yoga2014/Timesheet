import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  baseUrl = "http://localhost:8080/auth/login";
  constructor(private http:HttpClient) { }

  authLogin(params:any){
    return this.http.post<any>(this.baseUrl,params);
  }
}

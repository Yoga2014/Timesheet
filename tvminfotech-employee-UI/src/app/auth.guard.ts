import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { SignupService } from './api/signup.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private routes:Router ,public guardService:SignupService){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
      if(this.guardService.isloggedIn()){
        return true
      }
      else{
        this.routes.navigate(['/login'])
        return false;
       
      }
     }
     
  }
  


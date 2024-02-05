import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpResponse
} from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { SignupService } from '../signup.service';
import { Router } from '@angular/router';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private Auth:SignupService,private router:Router) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const myToken = this.Auth.getToken();
    if(myToken){
      request =request.clone({
        setHeaders:{Authorization:`Barrer ${myToken}`}
      })
    }
    return next.handle(request).pipe(
      catchError((err:any)=>{
        if( err instanceof HttpResponse){
           if(err.status === 401){
            this.router.navigate(['/login'])
           }
        }
        return throwError(()=> new Error(" some other error occured "))
      })
    );
    
  }
}

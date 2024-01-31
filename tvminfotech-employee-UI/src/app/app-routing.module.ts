import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { AssetsComponent } from './assets/assets.component';
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component';
// import { SignupComponent } from './signup/signup.component';
import { AttendanceComponent } from './attendance/attendance.component';
import { AuthGuard } from './auth.guard';
import { SignupComponent } from './signup/signup.component';



const routes: Routes = [
  // { path: '', redirectTo: '/navbar', pathMatch: 'full' },
  {path:'',component:LoginComponent},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'home',component:HomeComponent,canActivate:[AuthGuard]},
  {path:'navbar',component:NavbarComponent,canActivate:[AuthGuard]},
  {path:'attendance',component:AttendanceComponent,canActivate:[AuthGuard]},
  {path:'assets',component:AssetsComponent,canActivate:[AuthGuard]},
  {path:'employee-detail',component:EmployeeDetailComponent,canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

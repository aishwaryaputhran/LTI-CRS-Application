import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NGXLogger } from 'ngx-logger';
import { User } from 'src/model/user';
import { MyUserServiceService } from '../service/my-user-service.service';
 
@Component({
 selector: 'app-login',
 templateUrl: './login.component.html',
 styleUrls: ['./login.component.css']
})

//Class to implement Login
export class LoginComponent implements OnInit {
 
    //user object
 userObj = new User('', '');
 model: any = {};
 role:any;
 constructor(private router: Router, private user: MyUserServiceService, private logger:NGXLogger) { }
 
 ngOnInit() {
 }
 
 // here this event is Auth the user name & password comes form web service 
 
 //method to login user
 loginUser() {
 
 const data = {
 username: this.userObj.userName,
 password: this.userObj.password,
 }
 
 localStorage.setItem('user_id', this.userObj.userName);
 
 this.user.checkLogin(data).subscribe((res: any) => {
 
 this.role = res;
 
 this.logger.info(this.role);
 if (this.role === "ADMIN") {
 this.router.navigate(['admin']);
 }
 if (this.role === "STUDENT") {
 this.router.navigate(['dashboardstudent']);
 }
 if (this.role === "PROFESSOR") {
 this.router.navigate(['professor']);
 }
 })
 
 
 
 }
 
}
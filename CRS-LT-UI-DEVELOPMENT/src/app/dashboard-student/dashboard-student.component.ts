import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NGXLogger } from 'ngx-logger';
import { MyStudentServiceService } from '../service/my-student-service.service';
 
@Component({
 selector: 'app-dashboard-student',
 templateUrl: './dashboard-student.component.html',
 styleUrls: ['./dashboard-student.component.css']
})
export class DashboardStudentComponent implements OnInit {
 title='Welcome To Student Menu';
 today=new Date();
 studentId:any;
 
 constructor(private logger: NGXLogger, private _httpService: MyStudentServiceService, private router: Router) { }
 
 ngOnInit(): void {
 this.getstudentId();
 }
 
 //Method to get student Id
 getstudentId(){
 let userName =localStorage.getItem('user_id');
 this._httpService.getstudentId(userName).subscribe((res:any)=>{
 localStorage.setItem('studentId',res);
 
 });
 
 // window.location.reload();
 }
 
 //Method to logout
 logout(){
 this.router.navigate(['']);
 }
 
}

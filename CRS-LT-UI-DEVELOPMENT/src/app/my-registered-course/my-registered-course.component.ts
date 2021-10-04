import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NGXLogger } from 'ngx-logger';
import { RegisteredCourse } from 'src/model/registered-course';
import { Student } from 'src/model/student';
import { MyStudentServiceService } from '../service/my-student-service.service';
 
 let id =localStorage.getItem('studentId');
 
@Component({
 selector: 'app-my-registered-course',
 templateUrl: './my-registered-course.component.html',
 styleUrls: ['./my-registered-course.component.css']
})

//Class to implement Registered Course service
export class MyRegisteredCourseComponent implements OnInit {
 
 regCourse: RegisteredCourse[] = [];
 
 model = new Student(0, '', '', '', '', 0, 0);
 getData: any[] = [];
 
 constructor(private logger: NGXLogger, private _httpService: MyStudentServiceService, private router: Router) {
 this.logger.debug('Inside the constructor of My component');
 }
 
 ngOnInit() {
 this._httpService.getRegisteredCourseDetails(id)
 .subscribe((data: any) => {
 this.getData = data;
 this.logger.debug("Grade Card: " + JSON.stringify(this.getData))
 });
 }
 
 // Method to delete course from list of registered course
 deleteCourse(regCourse: RegisteredCourse): void{
 this._httpService.deleteCourse(id, regCourse.courseId)
 .subscribe(data => { 
 this.regCourse = this.regCourse.filter(u => u !== regCourse); 
 }) 
 }
 
 
 
}
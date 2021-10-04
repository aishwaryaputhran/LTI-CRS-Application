import { Component, OnInit } from '@angular/core';
import { NGXLogger } from 'ngx-logger';
import { Student } from 'src/model/student';
import { MyStudentServiceService } from '../service/my-student-service.service';
import { RegisteredCourse } from 'src/model/registered-course'
import { Router } from '@angular/router';
 
let id =localStorage.getItem('studentId');
 
@Component({
 selector: 'app-my-course-registration',
 templateUrl: './my-course-registration.component.html',
 styleUrls: ['./my-course-registration.component.css']
})

//Class to implement Course registration service
export class MyCourseRegistrationComponent implements OnInit {
 
 model = new RegisteredCourse('', '', 0, '', 0)
 getData: any[] = [];
 
 constructor(private logger: NGXLogger, private _httpService: MyStudentServiceService, private router: Router) {
 this.logger.debug('Inside the constructor of My component');
 }
 
 ngOnInit() {
 this._httpService.getAvailableCourseDetails() 
 .subscribe((data :any) => {
 this.getData = data;
 this.logger.debug("Grade Card: "+JSON.stringify(this.getData)) 
 }); 
 }
 
 // Method to register course
 registerCourse(): void{
 this._httpService.regCourse(id, this.model.courseId)
 .subscribe(data => { 
 this.router.navigate(['registeredCourse']); 
 }, 
 error => { 
 alert("Course added Successfully...."); 
 this.router.navigate(['registeredCourse']);
 });
 }
 
 //Method to add course
 addregCourse()
 {
 
 }
 
 //Method to delete Courses
 deleteCourse(){
 
 }
 
}
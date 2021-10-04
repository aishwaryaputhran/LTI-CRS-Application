import { Component, OnInit } from '@angular/core';
import { NGXLogger } from 'ngx-logger';
 
import { AdminServiceService } from '../service/admin-service.service';
import { Catlog } from 'src/model/catlog';
import { Course } from 'src/model/course';
 
@Component({
  selector: 'app-edit-course',
  templateUrl: './edit-course.component.html',
  styleUrls: ['./edit-course.component.css']
})

//Class to implement Edit Course
export class EditCourseComponent implements OnInit {
 
  constructor(private logger:NGXLogger, private _httpService:AdminServiceService) {
    this.logger.debug('Inside the constructor of My component');
    }
 
    //course catlog array
  catlogCourse: any=[];
  //course array
  course:any=[];
 
  
  ngOnInit(): void {
    this.getCatlogCourse();
    this.getCourse();
  }
 
  //to get the list of catlogcourses
  getCatlogCourse()
  {
      this._httpService.getCatlogCourses().subscribe(data => {
          this.catlogCourse = data;
      });
  }
 
  //method to add the courses
  addCourse():void
  {
       const data = {
         courseId:this.course.courseId,
         courseName:this.course.courseName,
         courseFee: this.course.courseFee
      };
  
      this._httpService.addCourses(data)
        .subscribe(
          response => {
            this.course = response.json();
            this.course= Array.of(this.course); 
            console.log(response);
          },
          error => {
            console.log(error);
          });
  }
 
  //method to get the courses added by admin
  getCourse()
  {
      this._httpService.getCourses().subscribe(data => {
          this.course = data;
      });
  }
  //method to delete the selected coursecode
  deleteCourse(courseCode:string):void
  {
    alert("Delete course-code "+courseCode);
    this._httpService.deleteCourse(courseCode)
      .subscribe(
        response => {
          console.log(response);     
        },
        error => {
          console.log(error);
        });
  }
}
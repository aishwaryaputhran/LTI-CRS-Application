import { Component, OnInit } from '@angular/core';
import { Grade } from 'src/model/grade';
import { NGXLogger } from 'ngx-logger';
import { ProfessorServiceService } from '../service/professor-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-grade',
  templateUrl: './add-grade.component.html',
  styleUrls: ['./add-grade.component.css']
})
//Class for Add Grade implementation
export class AddGradeComponent implements OnInit {

  constructor(private logger: NGXLogger, private _httpService: ProfessorServiceService, private router: Router) {
    this.logger.debug('Inside the constructor of My component');
  }

  //Grade Array
  gradeArray: Array<Grade> = new Array;
  model = new Grade('', '', '', 0);

  ngOnInit(): void {
    this.getGrade();
  }


  //Method to get Grade details
  getGrade() { 
    this._httpService.getGradeCard()
    .subscribe(
      data => { this.gradeArray = data; }); }


  //Method to add the Grade details
  addGrades(): void 
  {
      const data = {
      courseCode: this.model.courseCode,
      courseName: this.model.courseName,
      grade: this.model.grade,
      studentId: this.model.studentId
    };
    this._httpService.addGrade(data)
      .subscribe(
        response => {
            this.gradeArray= Array.of(response);
            // this.model = response.json();
            // this.gradeArray= Array.of(this.model);
          console.log(response);
        },
        error => {
          console.log(error);
        });
  }

}

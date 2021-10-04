import { Component, OnInit } from '@angular/core';
import { NGXLogger } from 'ngx-logger';
import { Router } from '@angular/router';
import { RegisteredCourse } from 'src/model/registered-course';
import { ProfessorServiceService } from '../service/professor-service.service';
import { Professor } from 'src/model/professor';

@Component({
  selector: 'app-registered-course',
  templateUrl: './registered-course.component.html',
  styleUrls: ['./registered-course.component.css']
})

//class to implement the Registered Course Service
export class RegisteredCourseComponent implements OnInit {

  getData: any[] = [];

  constructor(private logger: NGXLogger, private _httpService: ProfessorServiceService, private router: Router) {
    this.logger.debug('Inside the constructor of My component');
  }

  ngOnInit() {
    this._httpService.viewRegisteredCourse()
      .subscribe((data: any) => {
        this.getData = data;
        this.logger.debug("Grade Card: " + JSON.stringify(this.getData))
      });
  }
}

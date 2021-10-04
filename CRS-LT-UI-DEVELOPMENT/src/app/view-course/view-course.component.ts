import { Component, OnInit } from '@angular/core';
import { NGXLogger } from 'ngx-logger';
import { Router } from '@angular/router';
import { Course } from 'src/model/course';
import { ProfessorServiceService } from '../service/professor-service.service';

@Component({
  selector: 'app-view-course',
  templateUrl: './view-course.component.html',
  styleUrls: ['./view-course.component.css']
})

//Class to implement View Course Service
export class ViewCourseComponent implements OnInit {

  getData: any[] = [];

  constructor(private logger: NGXLogger, private _httpService: ProfessorServiceService, private router: Router) {
    this.logger.debug('Inside the constructor of My component');
  }

  ngOnInit() {
    this._httpService.viewCourses()
      .subscribe((data: any) => {
        this.getData = data;
        this.logger.debug("Grade Card: " + JSON.stringify(this.getData))
      });
  }
}

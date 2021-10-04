import { Component, OnInit } from '@angular/core';
import { NGXLogger } from 'ngx-logger';
import { Grade } from 'src/model/grade';
import { MyStudentServiceService } from '../service/my-student-service.service';
import { Router } from '@angular/router';
 
let id =localStorage.getItem('studentId');
 
@Component({
 selector: 'app-my-grade-card',
 templateUrl: './my-grade-card.component.html',
 styleUrls: ['./my-grade-card.component.css']
})

//class to implement Grade card details
export class MyGradeCardComponent implements OnInit {
 
 getData: any[] = [];
 
 constructor(private logger: NGXLogger, private _httpService: MyStudentServiceService, private router: Router) {
 this.logger.debug('Inside the constructor of My component');
 }
 
 ngOnInit() {
 
 this._httpService.getGradeCard(id) 
 .subscribe((data :any) => {
 this.getData = data;
 this.logger.debug("Grade Card: "+JSON.stringify(this.getData)) 
 }); 
 
 }
 
}
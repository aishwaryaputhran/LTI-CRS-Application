import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/model/admin';
import { NGXLogger } from 'ngx-logger';
import { AdminServiceService } from '../service/admin-service.service';
import { Professor } from 'src/model/professor';
import { Course } from 'src/model/course';

@Component({
  selector: 'app-admin-component',
  templateUrl: './admin-component.component.html',
  styleUrls: ['./admin-component.component.css']
})
export class AdminComponentComponent implements OnInit {

  title="Welcome to Admin";
  //Admin array
  adminArray:Array<Admin>=new Array;
  //model=new Admin('','');
  //model=new Admin('','',0);

  //Professor Array
  profArray:Array<Professor>=new Array;
  model=new Professor('','','','','');
  
  //Course array
  courseArray:Array<Course>=new Array;
  model1=new Course('','',0);

  // getData:any[];
  btnVal = "Approval Pending";
  
  constructor(private logger:NGXLogger, private _httpService:AdminServiceService) {
    this.logger.debug('Inside the constructor of My component');
    }

  ngOnInit(): void {
  }
  
  //Method to get Admin
  getAdmin()
  {
    console.log(JSON.stringify(this.adminArray));
  }
}
import { Component, OnInit } from '@angular/core';
import { NGXLogger } from 'ngx-logger';
 
import { Admin } from 'src/model/admin';
import { Professor } from 'src/model/professor';
import { AdminServiceService } from '../service/admin-service.service';
 
@Component({
  selector: 'app-add-professor',
  templateUrl: './add-professor.component.html',
  styleUrls: ['./add-professor.component.css']
})
//Class to implement Add Professor service
export class AddProfessorComponent implements OnInit {
 
  constructor(private logger:NGXLogger, private _httpService:AdminServiceService) {
    this.logger.debug('Inside the constructor of Add-professor component');
    }
 
    professor: any=[];
    submitted=true;
 
  ngOnInit(): void {
    this.getProfessor();
  }
 
  //Method to add the professor 
  createProfessor(): void 
  {
      const data = {
      professorName: this.professor.professorName,
      userName: this.professor.userName,
      password: this.professor.password,
      department: this.professor.department,
      professorAddress: this.professor.professorAddress
    };
 
    this._httpService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }
 
  //Method to get the list of professor added by admin
  getProfessor() 
  {
    this._httpService.getListProfessor().subscribe(data => {
        this.professor = data;
    });
  }
 
  
}
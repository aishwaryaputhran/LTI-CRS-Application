import { Component, OnInit } from '@angular/core';
import { NGXLogger } from 'ngx-logger';
import { AdminServiceService } from '../service/admin-service.service';
import { Student } from 'src/model/student';
 
@Component({
  selector: 'app-approve-student',
  templateUrl: './approve-student.component.html',
  styleUrls: ['./approve-student.component.css']
})
export class ApproveStudentComponent implements OnInit {
 
  constructor(private logger:NGXLogger, private _httpService:AdminServiceService) {
    this.logger.debug('Inside the constructor of ApproveStudent component');
    }
 
    studentArray: any=[];
    submitted=true;
    btnVal = "Approval Pending";
 
    student: Student = {
      studentId: 0,
      studentName: '',
      isApproved: 0,
      studentAddress:'',
      studentEmailId:'',
      studentContactNo:0,
      branch:''
    };
    message = '';
  
  
 
  ngOnInit(): void {
    this.userDetails();
  }
 
  // userDetails(){
  //   this._httpService.listOfApprovalPending()
  //   .subscribe((res : any[])=>{
  //   //console.log(res);
  //   this.logger.debug(res);
  //   this.getData =res;
  // });
  // }
 
  // updateApproval(id:number)
  // {
  //   this.getData.forEach((ele, index)=> {
  //         if(ele.id==id){
  //           this.btnVal = "Approved"
  //         }
  //       });
    
  // }
 
  userDetails() 
  {
    this._httpService.  listOfApprovalPending()
    .subscribe(data => {
        this.studentArray = data;
    });
  }
 
  // updateApproval(studentId:number)
  // {
  //   this.student.forEach((ele, index)=> {
  //         if(ele.studentId==studentId){
  //           this.btnVal = "Approved"
  //         }
  //       });
  // }
  // updateApproval(studentId:number): void 
  // {
  //   const data = {
  //     studentId: this.student.studentId,
  //     studentName: this.student.studentName,
  //     isApproved: this.student.isApproved
  //   };
 
  //   this._httpService.getisApproved(this.student.studentId,data)
  //     .subscribe(
  //       response => {
  //         this.student.isApproved=1;
  //         this.btnVal="Approved";
  //         console.log(response);
  //       },
  //       error => {
  //         console.log(error);
  //       });
  // }
 
  updateApproval(studentId:number): void {
    alert(studentId);
    this._httpService.getisApproved(studentId)
      .subscribe(
        response => {
          this.student.isApproved=1;
          console.log(response);     
        },
        error => {
          console.log(error);
        });
  }
 
}
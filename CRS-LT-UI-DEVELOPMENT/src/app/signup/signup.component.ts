import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NGXLogger } from 'ngx-logger';
import { MyUserServiceService } from '../service/my-user-service.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

//class to implement the Signup service
export class SignupComponent implements OnInit {

  constructor(private router: Router, private userService: MyUserServiceService, private logger:NGXLogger) { }
 
    user: any=[];
    submitted=true;
 
  ngOnInit(): void {
    // this.getUser();
  }

  // Method to signup or create student profile
  createUser(): void 
  {
      const data = {
        studentName: this.user.studentName,
        password: this.user.password,
        studentContactNo: this.user.studentContactNo,
        studentEmailId: this.user.studentEmailId,
        studentAddress: this.user.studentAddress,
        branch: this.user.branch,
    };

    this.userService.signup(data)
      .subscribe(
        response => {
          console.log(response);
          alert(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }
 
  //Method to get the list of professor added by admin
  // getUser() 
  // {
  //   this._httpService.getListProfessor().subscribe(data => {
  //       this.user = data;
  //   });
  // }
 
}

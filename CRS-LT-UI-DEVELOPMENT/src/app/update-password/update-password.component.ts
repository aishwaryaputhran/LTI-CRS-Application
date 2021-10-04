import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NGXLogger } from 'ngx-logger';
import { User } from 'src/model/user';
import { MyUserServiceService } from '../service/my-user-service.service';

@Component({
  selector: 'app-update-password',
  templateUrl: './update-password.component.html',
  styleUrls: ['./update-password.component.css']
})
export class UpdatePasswordComponent implements OnInit {


  //user object
  userObj = new User('', '');
  model: any = {};
  role: any;
  constructor(private router: Router, private user: MyUserServiceService, private logger: NGXLogger) { }

  ngOnInit() {
  }

  // here this event is Auth the user name & password comes form web service 

  //method to update password
  updatePassword(username:String, password:String): void {
    alert(username);
    this.user.updatePass(username, password)
      .subscribe(
        response => {
          this.userObj.password=password;
          console.log(response);     
        },
        error => {
          console.log(error);
        });
  }

}

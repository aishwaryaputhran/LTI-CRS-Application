import { Component, OnInit } from '@angular/core';
import { NGXLogger } from 'ngx-logger';
import { MyStudentServiceService } from '../service/my-student-service.service';
import { Router } from '@angular/router';
import { Payment } from 'src/model/payment';
 
let id =localStorage.getItem('studentId');
 
@Component({
 selector: 'app-my-credit-card',
 templateUrl: './my-credit-card.component.html',
 styleUrls: ['./my-credit-card.component.css']
})

//Class to implement the Payment Service
export class MyCreditCardComponent implements OnInit {
 paymentObj = new Payment(0, '', 0, 0, 0);
 model: any;
 paymentDone=true;
 message:any;
 constructor(private logger: NGXLogger, private _httpService: MyStudentServiceService, private router: Router) { }
 
 ngOnInit(): void {
 }
 
 //Method to register course
 registerCourse(): void{
 
 const data = {
 mode: this.paymentObj.mode,
 amount: this.paymentObj.amount,
 }
 
 this._httpService.payment(id, data.mode,data.amount)
 .subscribe(data => { 
 if(data==="done"){
 this.message="Payment done Succesfully...";
 }
 this.router.navigate(['registeredCourse']); 
 }, 
 error => { 
 alert("Payment done Successfully...."); 
 this.router.navigate(['registeredCourse']);
 });
 }
 
}
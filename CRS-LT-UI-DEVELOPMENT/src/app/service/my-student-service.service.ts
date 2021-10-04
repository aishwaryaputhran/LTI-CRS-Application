import { Injectable } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';
import { Grade } from 'src/model/grade';
import { RegisteredCourse } from 'src/model/registered-course';
 
const baseURL = 'http://127.0.0.1:8081/Student';
 
@Injectable({
 providedIn: 'root' // this provide defaulat scope is root that means service scope is accessable entire in angular application
 
})

/**
 *
 * @author G4-FullStackGroup
 * Class for Student Service
 *
 */
export class MyStudentServiceService {
 
 constructor(private http: HttpClient, private logger: NGXLogger) { }
 
 headers = new HttpHeaders()
 .set('content-type', 'application/json')
 .set('Access-Control-Allow-Origin', '*');
 
 //we need to refer all the spring rest url's here
 
 // Method to return the student with Id
 getstudentId(userName:any){
 return this.http.post(`${baseURL}/${'getStudentId'}/${userName}`, { 'headers': this.headers });
 }
 
 //Method to get available Courses
 getAvailableCourseDetails(): Observable<any> {
 return this.http.get(`${baseURL}/${'viewAvailableCourses'}`, { 'headers': this.headers });
 }
 
 //Method to get Registered Courses
 getRegisteredCourseDetails(id:any): Observable<any> {
 return this.http.get(`${baseURL}/${'viewRegisteredCourses'}/${id}`, { 'headers': this.headers });
 }
 
 //Method to get Grade Card
 getGradeCard(id:any): Observable<any> {
 return this.http.get(`${baseURL}/${'viewGradeCard'}/${id}`, { 'headers': this.headers });
 }
 
 //Method to delete Courses
 deleteCourse(id:any, courseId:any){
 return this.http.delete<RegisteredCourse[]>(`${baseURL}/${'dropCourse'}/${id}/${courseId}`, { 'headers': this.headers });
 }
 
 //Method to register for courses
 regCourse(id:any, courseId:any){
 return this.http.post(`${baseURL}/${'registerCourse'}/${id}/${courseId}`, { 'headers': this.headers });
 }
 
 //Method to do the Payment
 payment(id:any,mode:any,amount:any){
 return this.http.post(`${baseURL}/${'getStudentId'}/${id}/${mode}/${amount}`, { 'headers': this.headers });
 }
}
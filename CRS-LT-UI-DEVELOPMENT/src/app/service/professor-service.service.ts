import { Injectable } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';
import { Grade } from 'src/model/grade';
import { RegisteredCourse } from 'src/model/registered-course';

const baseURL = 'http://127.0.0.1:8081/Professor';
@Injectable({
  providedIn: 'root' // this provide defaulat scope is root that means service scope is accessable entire in angular application

})
/**
 *
 * @author G4-FullStackGroup
 * Class for Professor Service
 *
 */
export class ProfessorServiceService { 

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  constructor(private http: HttpClient, private logger: NGXLogger) { }

  headers = new HttpHeaders()
  .set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*');

  //Method to get Registered courses by Students
  viewRegisteredCourse(): Observable<any>
  {
    return this.http.get(`${baseURL}/${'viewRegisteredCourses'}`, { 'headers': this.headers });
  }

  //Method to view all courses
  viewCourses(): Observable<any>
  {
    return this.http.get(`${baseURL}/${'viewCourses'}`, { 'headers': this.headers });
  }

  //Method to get the Grade Card details
  getGradeCard(): Observable<any>{
    return this.http.get("http://127.0.0.1:8081/Professor/getGrade");
  }

  //Method to add Grade
  addGrade(data: any): Observable<any> {
    return this.http.post("http://127.0.0.1:8081/Professor/addGradeCard", JSON.stringify(data), this.httpOptions);
  }
}

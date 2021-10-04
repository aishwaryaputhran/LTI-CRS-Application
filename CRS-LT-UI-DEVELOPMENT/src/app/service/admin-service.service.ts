import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Professor } from 'src/model/professor';
 
const baseURL = 'http://127.0.0.1:8081/Admin';
 
@Injectable({
  providedIn: 'root'
})

/**
 *
 * @author G4-FullStackGroup
 * Class for AdminService
 *
 */
export class AdminServiceService {
 
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  constructor(private http:HttpClient) { }
 
  //A method to return the list of pending Approval Student
  listOfApprovalPending()
  {
    return this.http.get("http://127.0.0.1:8081/Admin/pendingApprovalStudent");
  }
 
  //A method to return the Approved Student
  getisApproved(id: any): Observable<any>
  {
    return this.http.put(`${baseURL}/${'approveStudent'}/${id}`, this.httpOptions);
  }
  
  
  // getCourse()
  // {
  //   return this.http.get("");
  // }
 
  // addProfessor(professor:Professor): Observable<any>
  // {
  //   const headers = { 'content-type': 'application/json'}  
  //   const body=JSON.stringify(professor);
  //   console.log(body)
  //   return this.http.post("http://localhost:8080/Admin/addProfessor", body,{'headers':headers})
  // }
   
  //to add the professor details
  create(data: any): Observable<any> {
    return this.http.post("http://127.0.0.1:8081/Admin/addProfessor", JSON.stringify(data), this.httpOptions);
  }
 
  //to get the list of professor added
  getListProfessor()
  {
    return this.http.get("http://127.0.0.1:8081/Admin/viewProfessor");
  }
 
  //to get the list of catalog courses
  getCatlogCourses()
  {
    return this.http.get("http://127.0.0.1:8081/Admin/viewCatalog");
    
  }
 
  //to add the courses
  addCourses(data: any): Observable<any>
  {
    return this.http.post("http://127.0.0.1:8081/Admin/addCourse", JSON.stringify(data), this.httpOptions);
  }
 
  //to get the list of courses added by admin
  getCourses():  Observable<any>
  {
    return this.http.get("http://127.0.0.1:8081/Admin/viewCourse");
  }
 
  //service to delete the course
  deleteCourse(courseCode: any): Observable<any>
  {
    return this.http.delete(`${baseURL}/${'deleteCourse'}/${courseCode}`);
  }
}
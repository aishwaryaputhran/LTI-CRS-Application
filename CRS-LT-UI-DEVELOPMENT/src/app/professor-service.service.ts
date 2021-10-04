import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProfessorServiceService {

  constructor(private http:HttpClient) { }

  viewRegisteredCourse()
  {
    return this.http.get("https://jsonplaceholder.typicode.com/users");
  }

  // addGrade()
  // {
  //   return this.http.get("");
  // }

  // viewCourse()
  // {
  //  return this.http.post("http://localhost:8080/Admin/addCourse",);
  // }
   
}

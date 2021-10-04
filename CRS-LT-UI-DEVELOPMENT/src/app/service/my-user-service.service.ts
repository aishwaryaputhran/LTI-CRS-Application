import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
 
const loginURL = 'http://127.0.0.1:8081/User/login';
const registerURL='http://127.0.0.1:8081/User/studentRegistration';
const updatePwdURL="http://127.0.0.1:8081/User/updatePassword";
 
const header =new HttpHeaders()
.set('content-type','application/json');
 
@Injectable({
 providedIn: 'root'
})
/**
 *
 * @author G4-FullStackGroup
 * Class for User Service
 *
 */
export class MyUserServiceService {
 
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
 constructor(private http: HttpClient) { }
 
 //Method to Login
 checkLogin(data:any) {
 return this.http.post(loginURL, data, { headers: header, responseType: 'text' });
 }
 
 //Method to Signup the student
 signup(data:any) {
  return this.http.post(registerURL, data, { headers: header, responseType: 'text' });
  }

  //Method to update password
  updatePass(username:String, password:String): Observable<any> {
    return this.http.put(`${updatePwdURL}/${username}/${password}`, this.httpOptions);
    }
}
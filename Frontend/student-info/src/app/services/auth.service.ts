import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Person } from '../models/person';
import { PersonService } from './person.service';
import { BehaviorSubject, Observable } from 'rxjs';

const LOGIN_PATH = "/user";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUserSubject : BehaviorSubject<Person>;
  currentUser : Observable<Person>;
  constructor(private http : HttpClient, private personService : PersonService) {
    this.currentUserSubject = new BehaviorSubject<Person>(JSON.parse(localStorage.getItem('user')));
    this.currentUser = this.currentUserSubject.asObservable();
   }

  create(user : Person) {
    return this.http.post<Person>(LOGIN_PATH + '/user/new', user) ;

  }

  login(username, password) {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
      observe: 'response' as 'response'
    };
    return this.http.post<any>(LOGIN_PATH + '/login', {"username" : username, "password" : password},httpOptions).subscribe((data : HttpResponse<any>) => {
      if (data.headers.get('authorization') !== "")
        localStorage.setItem("token", data.headers.get('authorization'));
        this.personService.fetch(data.headers.get('user'))
        .subscribe(
          (response => {
            localStorage.setItem('user',JSON.stringify(response.body));
            this.currentUserSubject.next(response.body);
          }),
          (error => {
            return error;
          })
        )

    });
  }

  logout() {
    this.currentUserSubject.next(null);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Person } from '../models/person';


@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private http : HttpClient) { }

  fetch(username : string) {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' , 'Authorization' : localStorage.getItem('token')}),
      observe: 'response' as 'response'
    };
    return this.http.get<Person>("apigateway/userUI/user/" + username, httpOptions);
  }
}

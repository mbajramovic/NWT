import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Experience } from '../models/experience';

const API_PATH = '/apigateway/experienceUI'

@Injectable({
  providedIn: 'root'
})
export class ExperienceService {
  httpOptions = {};
  constructor(private http : HttpClient) { 
    this.httpOptions  = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' , 'Authorization' : localStorage.getItem('token')}),
      observe: 'response' as 'response'
    };
  }

  fetch() {
    return this.http.get<any>(API_PATH + '/experiences', this.httpOptions).pipe(map((res : any) => {
      return res.body != null ? res.body : res;
    }));
  }

  save(experience : Experience) {
    return this.http.post<Experience>(API_PATH + '/experience', experience, this.httpOptions).pipe(map((res : any) => {
      return res;
    }));
  }

  get(id : Number) {
    return this.http.get<Experience>(API_PATH + '/experience/' + id, this.httpOptions).pipe(map((res : any) => {
      return res.body != null ? res.body : res;
    }))
  }
}

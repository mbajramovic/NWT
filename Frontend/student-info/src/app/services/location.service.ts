import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Location } from '../models/Location';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

const PATH = "/apigateway/apartmentUI"; // treba promijeniti putanje na ovo

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  httpOptions = {};
   

  constructor(private http: HttpClient) {
    this.httpOptions  = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' , 'Authorization' : localStorage.getItem('token')}),
      observe: 'response' as 'response'
    };
   }
  
  getCountries(): Observable<String[]> {
    return this.http.get('http://localhost:8082/location/countries', this.httpOptions).pipe(map((res: String[]) => {
      return res;
    }));
  }
}

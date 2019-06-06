import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Location } from '../models/Location';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  constructor(private http: HttpClient) { }

  getCountries(): Observable<String[]> {
    return this.http.get('http://localhost:8082/location/countries').pipe(map((res: String[]) => {
      return res;
    }));
  }
}

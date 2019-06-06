import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Apartment } from '../models/apartment';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApartmentService {

  constructor(private http: HttpClient) { }

  getApartments(): Observable<Apartment[]> {
    return this.http.get('http://localhost:8082/apartments').pipe(map((res: Apartment[]) => {
      return res;
    }));
  }

  postApartments(apartment: Apartment) {
    let body = JSON.stringify(apartment);
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post('http://localhost:8082/apartment', body, { "headers": headers }).subscribe((response) => {
    console.log(response);
    
    return <any>response;
    });
  }
}

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Apartment } from '../models/apartment';
import { map } from 'rxjs/operators';

const PATH = "/apigateway/apartmentUI"; 

@Injectable({
  providedIn: 'root'
})
export class ApartmentService {
  httpOptions : {};
  constructor(private http: HttpClient) {
    this.httpOptions  = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' , 'Authorization' : localStorage.getItem('token')}),
      observe: 'response' as 'response'
    };
   }

  getApartments(): Observable<Apartment[]> {
    return this.http.get('http://localhost:8090/apartments', this.httpOptions).pipe(map((res: any) => {
      
      return res.body;
    }));
  }

  postApartments(apartment: Apartment) {
    let body = JSON.stringify(apartment);
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post('http://localhost:8090/apartment', body, this.httpOptions).subscribe((response) => {
    console.log(response);
    
    return <any>response;
    });
  }
}

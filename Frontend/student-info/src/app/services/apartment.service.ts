import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Apartment } from '../models/apartment';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApartmentService {

  constructor(private http: HttpClient) { }

  getApartments(): Observable<Apartment[]>{
    return this.http.get('http://localhost:8082/apartments').pipe(map((res: Apartment[]) => {
      console.log(res);
      return res;
    }));
  }
}

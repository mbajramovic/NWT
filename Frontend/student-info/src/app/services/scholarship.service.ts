import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Scholarship } from '../models/scholarship';
import { map } from 'rxjs/operators';

const PATH = "/apigateway/scholarshipUI"; // treba promijeniti putanje na ovo

@Injectable({
  providedIn: 'root'
})
export class ScholarshipService {
  httpOptions = {};
  constructor(private http: HttpClient) {
    this.httpOptions  = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' , 'Authorization' : localStorage.getItem('token')}),
      observe: 'response' as 'response'
    };
   }

  getScholarships(): Observable<Scholarship[]> {
    return this.http.get(PATH + '/scholarship', this.httpOptions).pipe(map((res: any) => {
      return res.body;
    }));
  }

  postScholarships(scholarship: Scholarship) {
    let body = JSON.stringify(scholarship);
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(PATH + '/scholarship', body, this.httpOptions).subscribe((response: Response) => {
      console.log(response);

      return <any>response;
    });
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Scholarship } from '../models/scholarship';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ScholarshipService {
  constructor(private http: HttpClient) { }

  getScholarships(): Observable<Scholarship[]> {
    return this.http.get('http://localhost:8050/scholarship').pipe(map((res: Scholarship[]) => {
      return res;
    }));
  }

  postScholarships(scholarship: Scholarship) {
    let body = JSON.stringify(scholarship);
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post('http://localhost:8050/scholarship', body, { "headers": headers }).subscribe((response: Response) => {
      console.log(response);

      return <any>response;
    });
  }
}

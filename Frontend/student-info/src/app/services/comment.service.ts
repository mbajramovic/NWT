import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Comment } from '../models/comment';

const PATH = '/apigateway/experienceUI';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  httpOptions = {};
  constructor(private http : HttpClient) {
    this.httpOptions  = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' , 'Authorization' : localStorage.getItem('token')}),
      observe: 'response' as 'response'
    };
   }

   fetch(id : Number) {
     return this.http.get(PATH + '/experience/' + id + '/comment', this.httpOptions).pipe(map((res : any) => {
       return res.body;
     }))
   }

   save (comment : Comment) {
     return this.http.post(PATH + '/comment', comment, this.httpOptions).pipe(map((res : any) => {
      console.log(res);
      return res;
      
     }));
   }
}

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from '../models/person';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Message } from '../models/message';

const PATH = "/apigateway/interactionUI"

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  httpOptions : {};
  constructor(private http: HttpClient) {
    this.httpOptions  = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' , 'Authorization' : localStorage.getItem('token')}),
      observe: 'response' as 'response'
    };
   }

  getRecipient(username: string): Observable<Person> {
    return this.http.get(PATH+'/user/username/'+username, this.httpOptions).pipe(map((res: Response) => {
      console.log(<any>res.body[0]);
      return (res && res.body) ? <any>res.body[0] : res;
    }));
  }

  sendMessage(message: Message){
    let body = JSON.stringify(message);
    console.log(body);
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(PATH + '/message', body, this.httpOptions).subscribe((response) => {
    console.log(response);
    
    return <any>response;
    });
  }

  getMessages(id: number): Observable<Message[]> {
    return this.http.get(PATH + '/user/'+id+'/messages', this.httpOptions).pipe(map((res: any) => {
      console.log(res);
      return res.body;
    }));
  }

  getMessage(id: number)  {
    return this.http.get(PATH + '/message/' + id, this.httpOptions).pipe(map((res : any) => {
      return res.body;
    }))
  }
}

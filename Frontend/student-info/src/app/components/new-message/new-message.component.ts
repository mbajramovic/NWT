import { Component, OnInit } from '@angular/core';
import { MessageService } from 'src/app/services/message.service';
import { Message } from '../../models/message';
import { Person } from '../../models/person';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-new-message',
  templateUrl: './new-message.component.html',
  styleUrls: ['./new-message.component.css']
})
export class NewMessageComponent implements OnInit {
  recipient: string;
  message: string;
  title: string;
  currentUser : Person;

  constructor(private _messageService: MessageService, private authService : AuthService) { 
    this.authService.currentUser.subscribe(x => this.currentUser = x);
  }

  ngOnInit() {
    this.message = "";
    this.title = "";
    this.recipient = "";
  }

  sendMessage(){
    console.log(this.recipient);
    	this._messageService.getRecipient(this.recipient).subscribe( result => {
        console.log(result);
        var message = new Message();
        message.text = this.message;
        message.title = this.title;
        message.sender = this.currentUser;
        message.recipient = this.currentUser;
        message.isRead = false;
        this._messageService.sendMessage(message);
      })
  }

}

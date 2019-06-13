import { Component, OnInit, Input } from '@angular/core';
import { Message } from '../../models/message';
import { MessageService } from 'src/app/services/message.service';
import { Person } from '../../models/person';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})
export class InboxComponent implements OnInit {

  messages: Message[];
  @Input() search: string;
  currentUser : Person;

  constructor(private _messageService: MessageService, private authService : AuthService) { 
    this.authService.currentUser.subscribe(x => this.currentUser = x);
  }

  ngOnInit() {
    this._messageService.getMessages(this.currentUser.id).subscribe(messages => this.messages = messages);
  }


}

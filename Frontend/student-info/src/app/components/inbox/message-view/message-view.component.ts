import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { MessageService } from 'src/app/services/message.service';
import { Person } from 'src/app/models/person';
import { Message } from 'src/app/models/message';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-message-view',
  templateUrl: './message-view.component.html',
  styleUrls: ['./message-view.component.css']
})
export class MessageViewComponent implements OnInit {
  currentUser : Person;
  message : Message;
  constructor(private authService : AuthService, private messageService : MessageService, private route : ActivatedRoute) 
  { 
    this.authService.currentUser.subscribe(x => this.currentUser = x);
  }

  getMessage(id) {
    this.messageService.getMessage(id).subscribe(res => {
      this.message = res;
    })
  }

  ngOnInit() {
    var id = Number.parseInt(this.route.snapshot.paramMap.get('id'));
    this.getMessage(id);
  }

}

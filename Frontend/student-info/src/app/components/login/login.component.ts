import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { first } from 'rxjs/operators';
import { HttpResponse } from '@angular/common/http';
import { Person } from 'src/app/models/person';
import { Router } from '@angular/router';
import { CommunicateService } from 'src/app/services/communicate.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username : string;
  password : string;

  currentUser : Person;

  constructor(private authService : AuthService, private router : Router, private communicateService : CommunicateService) { 
    this.authService.currentUser.subscribe(x => {
      this.currentUser = x;
      if (this.currentUser != null) {
        this.router.navigate(['/apartments']);
        this.communicateService.onAuthorized(true);
      }
      else {
        this.communicateService.onAuthorized(false);
      }
    });
  }

  ngOnInit() {
  }

  login() {
    this.authService.login(this.username, this.password);

  
  }

}

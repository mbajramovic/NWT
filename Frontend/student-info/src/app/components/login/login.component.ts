import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { first } from 'rxjs/operators';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username : string;
  password : string;

  constructor(private authService : AuthService) { }

  ngOnInit() {
  }

  login() {
    this.authService.login(this.username, this.password);
  
  }

}

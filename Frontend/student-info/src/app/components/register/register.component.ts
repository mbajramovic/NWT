import { Component, OnInit } from '@angular/core';
import { CommunicateService } from 'src/app/services/communicate.service';
import { AuthService } from 'src/app/services/auth.service';
import { Person } from 'src/app/models/person';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  name : string;
  email : string;
  username : string;
  password : string;

  constructor(
    private _communicationService: CommunicateService,
    private authService : AuthService
    ) { }

  ngOnInit() {
  }

  onRegister(event: any){
    //this._communicationService.onAuthorized(true);
    var person = new Person(this.name, this.email, this.username, this.password, "USER");
    var res = this.authService.create(person).subscribe(
      (resp) => {
        console.log(resp);
      },
      (error) => {
        console.log(error);
      } 
    );
  }

}

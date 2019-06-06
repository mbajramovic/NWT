import { Component, OnInit } from '@angular/core';
import { CommunicateService } from 'src/app/services/communicate.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private _communicationService: CommunicateService) { }

  ngOnInit() {
  }

  onRegister(event: any){
    this._communicationService.onAuthorized(true);
  }

}

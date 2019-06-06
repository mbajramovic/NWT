import { Component } from '@angular/core';
import { CommunicateService } from './services/communicate.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'student-info';
  authorized = false;

  isRegisterClicked: boolean;

  constructor(private _communicationService: CommunicateService) { }

  ngOnInit() {
    this.isRegisterClicked = true;

    this._communicationService.auhorized.subscribe(value => this.authorized = value);
  }

  onRegistrateChanged(value: boolean){
    this.isRegisterClicked = value;
  }
}

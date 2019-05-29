import { Component, OnInit } from '@angular/core';
import { CommunicateService } from 'src/app/services/communicate.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  isRegisterClicked: boolean;

  constructor(private _communicationService: CommunicateService) { }

  ngOnInit() {
    this.isRegisterClicked = true;

    this._communicationService.changeVisability.subscribe(value => this.isRegisterClicked = value);

  }


}

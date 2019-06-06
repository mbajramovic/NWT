import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { CommunicateService } from 'src/app/services/communicate.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  isClicked:boolean;
  @Input() set isRegistrateClicked(value: boolean)
  {
    this.isClicked = value;
  };
  @Output() registrateChanged = new EventEmitter<boolean>();

  constructor(private _communicateService: CommunicateService) { }

  ngOnInit() {
  }

  onSignUpClicked() {
    this._communicateService.onVisablilityChanged(true);
  }

  onLoginClicked(){
    this._communicateService.onVisablilityChanged(false);
  }

  onSearchChanged(event: any){
    console.log(event.target.value);
    this._communicateService.onSearchChanged(event.target.value);
  }


}

import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'student-info';

  isRegisterClicked: boolean;

  constructor() { }

  ngOnInit() {
    this.isRegisterClicked = true;
  }

  onRegistrateChanged(value: boolean){
    this.isRegisterClicked = value;
  }
}

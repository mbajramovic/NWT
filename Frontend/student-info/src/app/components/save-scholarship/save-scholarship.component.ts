import { Component, OnInit } from '@angular/core';
import { ScholarshipService } from 'src/app/services/scholarship.service';
import { Location } from 'src/app/models/location';
import { Scholarship } from 'src/app/models/scholarship';
import { Person } from 'src/app/models/person';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-save-scholarship',
  templateUrl: './save-scholarship.component.html',
  styleUrls: ['./save-scholarship.component.css']
})
export class SaveScholarshipComponent implements OnInit {
  text: string;
  link: string;
  city: string;
  country: string;
  currentUser : Person;

  constructor(private _scholarshipService: ScholarshipService, private authService : AuthService) { 
    this.authService.currentUser.subscribe(x => this.currentUser = x);
  }

  ngOnInit() {
  }

  onSaveClicked(){
    var scholarship = new Scholarship(this.text, this.link, new Date(), new Location(101, '', this.city,this.country), this.currentUser);
    var res = this._scholarshipService.postScholarships(scholarship);
  }

}

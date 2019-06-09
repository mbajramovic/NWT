import { Component, OnInit } from '@angular/core';
import { Apartment } from 'src/app/models/apartment';
import { Person } from 'src/app/models/person';
import { Location } from 'src/app/models/location';
import { ApartmentService } from 'src/app/services/apartment.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-save-apartment',
  templateUrl: './save-apartment.component.html',
  styleUrls: ['./save-apartment.component.css']
})
export class SaveApartmentComponent implements OnInit {
  title: string;
  description: string;
  address: string;
  city: string;
  price: string;
  currentUser : Person;

  constructor(private _apartmentService: ApartmentService, private authService : AuthService) { 
    this.authService.currentUser.subscribe(x => this.currentUser = x);
  }

  ngOnInit() {
  }

  onSaveClicked(){
    var apartment = new Apartment(0, this.description, this.title, this.currentUser, new Location(101, this.address, this.city, ''), '', +this.price)
    var res = this._apartmentService.postApartments(apartment);
    console.log(res);
  }

}

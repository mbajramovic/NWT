import { Component, OnInit } from '@angular/core';
import { Apartment } from 'src/app/models/apartment';
import { Person } from 'src/app/models/person';
import { Location } from 'src/app/models/location';
import { ApartmentService } from 'src/app/services/apartment.service';

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

  constructor(private _apartmentService: ApartmentService) { 
    
  }

  ngOnInit() {
  }

  onSaveClicked(){
    var apartment = new Apartment(0, this.description, this.title, new Person(100, 'abecic', 'abecic'), new Location(101, '', '',''), '')
    var res = this._apartmentService.postApartments(apartment);
    console.log(res);
  }

}

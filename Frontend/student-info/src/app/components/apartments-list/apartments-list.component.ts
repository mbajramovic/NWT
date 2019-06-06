import { Component, OnInit, Input } from '@angular/core';
import { ApartmentService } from 'src/app/services/apartment.service';
import { Apartment } from 'src/app/models/apartment';
import { Person } from 'src/app/models/person';
import { Location } from 'src/app/models/Location';
import { CommunicateService } from 'src/app/services/communicate.service';

@Component({
  selector: 'app-apartments-list',
  templateUrl: './apartments-list.component.html',
  styleUrls: ['./apartments-list.component.css']
})
export class ApartmentsListComponent implements OnInit {
  apartments: Apartment[];
  filteredApartments: Apartment[];
  search: string;
  country: string;

  constructor(private _apartmentService: ApartmentService, private _communicationService: CommunicateService) { }

  ngOnInit() {
    this.country = "";
    this.search = ""; 
    
    this._apartmentService.getApartments().subscribe(apartments => {
      this.apartments = apartments;
      this.filteredApartments = apartments;
    });

    this._communicationService.searchChanged.subscribe(searchValue => {
      console.log(searchValue);
        this.search = searchValue;
        this.filterApartments();
    });

    this._communicationService.countryChanged.subscribe(country => {
      this.country = country;
      this.filterApartments();
    });
  }

  filterApartments(){
    this.filteredApartments = this.apartments;
    this.filteredApartments = (this.country == "Sve" || this.country == "") ? this.filteredApartments : this.filteredApartments.filter(x => x.location.country == this.country);
    this.filteredApartments = (this.search == "") ? this.filteredApartments : this.filteredApartments.filter(x => x.title.toLocaleLowerCase().includes(this.search.toLocaleLowerCase()));

  }

}

import { Component, OnInit, Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { CommunicateService } from '../../services/communicate.service';
import { SortingCriteria } from '../../enums/sorting-criteria.enum';
import { LocationService } from 'src/app/services/location.service';
import { Location } from 'src/app/models/Location';

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css']
})
export class FiltersComponent implements OnInit {
  checked: boolean;
  ascending: boolean;
  countries: String[];
  selectedCountry = "Sve";

  constructor(private communicateService: CommunicateService, private _locationService: LocationService) { }

  ngOnInit() {
    this.checked = false;
    this.ascending = true;

    this._locationService.getCountries().subscribe(countries => {
      this.countries = countries;
    });
  }

  toggleChange(event) {
    let checkedValue = event.target.getAttribute("id");
    let parentValue = document.getElementById(checkedValue).parentNode.parentElement.getAttribute("id");
  }

  sortChange(event) {
    let checkedValue = event.target.getAttribute("id");
      
  }

  countryChanged(){
    this.communicateService.onCountryChanged(this.selectedCountry);
  }

  onChecked(event: any){
    console.log(event.target.value);
    this.communicateService.onSortChanged(event.target.value);
  }
}

import { Component, OnInit, Input } from '@angular/core';
import { ApartmentService } from 'src/app/services/apartment.service';
import { Apartment } from 'src/app/models/apartment';
import { Person } from 'src/app/models/person';
import { Location } from 'src/app/models/Location';
import { CommunicateService } from 'src/app/services/communicate.service';
import PriceRangeModel from '../price-slider/price-range.model';
import { SortingCriteria } from 'src/app/enums/sorting-criteria.enum';

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
  priceRange: PriceRangeModel;
  sortingCriteria: SortingCriteria;

  constructor(private _apartmentService: ApartmentService, private _communicationService: CommunicateService) { }

  ngOnInit() {
    this.country = "";
    this.search = ""; 
    this.sortingCriteria = SortingCriteria.Name;
    this.priceRange = new PriceRangeModel(0, 5000);
    
    this._apartmentService.getApartments().subscribe(apartments => {
      this.apartments = apartments;
      this.filteredApartments = apartments;
    });

    this._communicationService.searchChanged.subscribe(searchValue => {
        this.search = searchValue;
        this.filterApartments();
    });

    this._communicationService.countryChanged.subscribe(country => {
      this.country = country;
      this.filterApartments();
    });

    this._communicationService.changePriceRange.subscribe(priceRange => {
      this.priceRange = priceRange;
      this.filterApartments();
    });

    this._communicationService.sortChanged.subscribe(sort => {
      this.sortingCriteria = sort;
      this.filterApartments();
    });
  }

  filterApartments(){
    this.filteredApartments = this.apartments;
    this.filteredApartments = (this.country == "Sve" || this.country == "") ? this.filteredApartments : this.filteredApartments.filter(x => x.location.country == this.country);
    this.filteredApartments = (this.search == "") ? this.filteredApartments : this.filteredApartments.filter(x => x.title.toLocaleLowerCase().includes(this.search.toLocaleLowerCase()));
    this.filteredApartments = this.filteredApartments.filter(x => x.price >= this.priceRange.minValue && x.price <= this.priceRange.maxValue);

    if(this.sortingCriteria == SortingCriteria.Name)
      this.filteredApartments.sort((item1, item2) => { return (item1.title > item2.title) ? 1 : -1;})
    else if(this.sortingCriteria == SortingCriteria.Price)
      this.filteredApartments.sort((item1, item2) => { return (item1.price > item2.price) ? 1 : -1;})
  }

}

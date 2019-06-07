import { Injectable, EventEmitter, Output } from '@angular/core';
import { SortingCriteria } from '../enums/sorting-criteria.enum';
import PriceRangeModel from '../components/price-slider/price-range.model';

@Injectable({
  providedIn: 'root'
})
export class CommunicateService {

  constructor() { }

  @Output() changeVisability: EventEmitter<boolean> = new EventEmitter();
  @Output() auhorized: EventEmitter<boolean> = new EventEmitter();
  @Output() searchChanged: EventEmitter<string> = new EventEmitter();
  @Output() countryChanged: EventEmitter<string> = new EventEmitter();
  @Output() changePriceRange: EventEmitter<PriceRangeModel> = new EventEmitter();
  @Output() sortChanged: EventEmitter<SortingCriteria> = new EventEmitter();

  onVisablilityChanged(value: boolean) {
    this.changeVisability.emit(value);
  }

  onAuthorized(value: boolean){
    this.auhorized.emit(value);
  }

  onSearchChanged(value: string){
    console.log(value);
    this.searchChanged.emit(value);
  }

  onCountryChanged(value: string){
    this.countryChanged.emit(value);
  }

  onPriceRangeChanged(value: PriceRangeModel){
    this.changePriceRange.emit(value);
  }

  onSortChanged(value: SortingCriteria){
    this.sortChanged.emit(value);
  }
}

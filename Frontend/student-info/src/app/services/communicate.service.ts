import { Injectable, EventEmitter, Output } from '@angular/core';
import { SortingCriteria } from '../enums/sorting-criteria.enum';

@Injectable({
  providedIn: 'root'
})
export class CommunicateService {

  constructor() { }

  @Output() changeVisability: EventEmitter<boolean> = new EventEmitter();

  onVisablilityChanged(value: boolean) {
    this.changeVisability.emit(value);
  }
}

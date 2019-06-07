import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Options } from 'ng5-slider';
import PriceRangeModel from './price-range.model';
import { CommunicateService } from 'src/app/services/communicate.service';

@Component({
  selector: 'app-price-slider',
  templateUrl: './price-slider.component.html',
  styleUrls: ['./price-slider.component.css']
})
export class PriceSliderComponent implements OnInit {
  @Output() onPriceRangeChanged: EventEmitter<PriceRangeModel> = new EventEmitter();

  constructor(private _communicationService: CommunicateService){}

  public priceRange: PriceRangeModel = new PriceRangeModel(0, 1000);

  public options: Options = {
    floor: 0,
    ceil: 1000
  };

  ngOnInit() {  }

  public rangeChanged(): void {
    this._communicationService.onPriceRangeChanged(this.priceRange);
  }

}

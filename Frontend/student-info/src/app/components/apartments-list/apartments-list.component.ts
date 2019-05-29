import { Component, OnInit, Input } from '@angular/core';
import { ApartmentService } from 'src/app/services/apartment.service';
import { Apartment } from 'src/app/models/apartment';
import { Person } from 'src/app/models/person';
import { Location } from 'src/app/models/Location';

@Component({
  selector: 'app-apartments-list',
  templateUrl: './apartments-list.component.html',
  styleUrls: ['./apartments-list.component.css']
})
export class ApartmentsListComponent implements OnInit {
  apartments: Apartment[];
  @Input() search: string;

  constructor(private _apartmentService: ApartmentService) { }

  ngOnInit() {
    this._apartmentService.getApartments().subscribe(apartments => this.apartments = apartments);
  }

}

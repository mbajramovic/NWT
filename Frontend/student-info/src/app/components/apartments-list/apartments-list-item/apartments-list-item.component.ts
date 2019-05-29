import { Component, OnInit, Input } from '@angular/core';
import { Apartment } from 'src/app/models/apartment';

@Component({
  selector: 'app-apartments-list-item',
  templateUrl: './apartments-list-item.component.html',
  styleUrls: ['./apartments-list-item.component.css']
})
export class ApartmentsListItemComponent implements OnInit {
  @Input() apartment: Apartment;
  @Input() search: string;

  constructor() { }

  ngOnInit() {
  }

}

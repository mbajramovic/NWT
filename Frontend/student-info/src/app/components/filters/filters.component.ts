import { Component, OnInit, Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { CommunicateService } from '../../services/communicate.service';
import { SortingCriteria } from '../../enums/sorting-criteria.enum';

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css']
})
export class FiltersComponent implements OnInit {
  checked: boolean;
  ascending: boolean;

  constructor(private communicateService: CommunicateService) { }

  ngOnInit() {
    this.checked = false;
    this.ascending = true;
  }

  toggleChange(event) {
    let checkedValue = event.target.getAttribute("id");
    let parentValue = document.getElementById(checkedValue).parentNode.parentElement.getAttribute("id");
  }

  sortChange(event) {
    let checkedValue = event.target.getAttribute("id");
      
  }
}

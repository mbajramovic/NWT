import { Component, OnInit } from '@angular/core';
import { Scholarship } from 'src/app/models/scholarship';
import { SortingCriteria } from 'src/app/enums/sorting-criteria.enum';
import { CommunicateService } from 'src/app/services/communicate.service';
import { ScholarshipService } from 'src/app/services/scholarship.service';

@Component({
  selector: 'app-scholarship-list',
  templateUrl: './scholarship-list.component.html',
  styleUrls: ['./scholarship-list.component.css']
})
export class ScholarshipListComponent implements OnInit {
  scholarships: Scholarship[];
  filteredScholarships: Scholarship[];
  search: string;
  country: string;
  sortingCriteria: SortingCriteria;

  constructor(private _scholarshipService: ScholarshipService, private _communicationService: CommunicateService) { }

  ngOnInit() {
    this.country = "";
    this.sortingCriteria = SortingCriteria.Name;

    this._scholarshipService.getScholarships().subscribe(scholarships => {
      this.scholarships = scholarships;
      console.log(scholarships);
      this.filteredScholarships = scholarships;
    });


    this._communicationService.countryChanged.subscribe(country => {
      this.country = country;
      this.filterScholarships();
    });

  }

  filterScholarships() {
    this.filteredScholarships = this.scholarships;
    this.filteredScholarships = (this.country == "Sve" || this.country == "") ? this.filteredScholarships : this.filteredScholarships.filter(x => x.location.country == this.country);

  }

  goToLink(url: string) {
    window.open(url, "_blank");
  }

}

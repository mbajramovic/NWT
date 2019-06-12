import { Component, OnInit } from '@angular/core';
import { ExperienceService } from 'src/app/services/experience.service';
import { Experience } from 'src/app/models/experience';

@Component({
  selector: 'app-experience-list',
  templateUrl: './experience-list.component.html',
  styleUrls: ['./experience-list.component.css']
})
export class ExperienceListComponent implements OnInit {
  experiences : Experience[];
  constructor(private experienceService : ExperienceService) { }

  ngOnInit() {
    this.getExperiences();
  }

  getExperiences() {
    this.experienceService.fetch().subscribe(res => {this.experiences = res; console.log(res);});
  }

}

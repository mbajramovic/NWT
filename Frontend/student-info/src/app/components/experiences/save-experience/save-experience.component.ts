import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Person } from 'src/app/models/person';
import { AuthService } from 'src/app/services/auth.service';
import { Experience } from 'src/app/models/experience';
import { ExperienceService } from 'src/app/services/experience.service';

@Component({
  selector: 'app-save-experience',
  templateUrl: './save-experience.component.html',
  styleUrls: ['./save-experience.component.css']
})
export class SaveExperienceComponent implements OnInit {
  experienceForm : FormGroup;
  currentUser : Person;
  submitted = false;
  newExperience : Experience;
  constructor(private formBuilder : FormBuilder, private authService : AuthService, private experienceService : ExperienceService) {
    this.authService.currentUser.subscribe(x => this.currentUser = x);
   }

  ngOnInit() {
    this.experienceForm = this.formBuilder.group({
      text : ['', [Validators.required, Validators.minLength(5), Validators.maxLength(1000)]],
      title : ['', Validators.required]
    });
  }

  get con() {
    return this.experienceForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    if (this.experienceForm.invalid)
      return;
    this.newExperience = this.experienceForm.value;
    this.newExperience.user = this.currentUser;
    this.experienceService.save(this.newExperience).subscribe(res => console.log(res));

  }

}
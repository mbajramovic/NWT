import { NgModule, InjectionToken } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApartmentsListComponent } from './components/apartments-list/apartments-list.component';
import { HomeComponent } from './components/home/home.component';
import { SaveApartmentComponent } from './components/save-apartment/save-apartment.component';
import { ScholarshipListComponent } from './components/scholarship-list/scholarship-list.component';
import { SaveScholarshipComponent } from './components/save-scholarship/save-scholarship.component';
import { ExperienceListComponent } from './components/experiences/experience-list/experience-list.component';
import { SaveExperienceComponent } from './components/experiences/save-experience/save-experience.component';
import { ExperienceViewComponent } from './components/experiences/experience-view/experience-view.component';

const externalUrlProvider = new InjectionToken('externalUrlRedirectResolver');

const routes: Routes = [
  { path: 'apartments', component: ApartmentsListComponent },
  { path: '', component: HomeComponent },
  { path: 'saveapartment', component: SaveApartmentComponent },
  { path: 'scholarships', component: ScholarshipListComponent },
  { path: 'savescholarship', component: SaveScholarshipComponent },
  {path : 'experiences', component : ExperienceListComponent},
  { path : 'saveexperience', component : SaveExperienceComponent},
  {path : 'experience/:id', component : ExperienceViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
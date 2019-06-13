import { NgModule, InjectionToken } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApartmentsListComponent } from './components/apartments-list/apartments-list.component';
import { HomeComponent } from './components/home/home.component';
import { SaveApartmentComponent } from './components/save-apartment/save-apartment.component';
import { ScholarshipListComponent } from './components/scholarship-list/scholarship-list.component';
import { SaveScholarshipComponent } from './components/save-scholarship/save-scholarship.component';
import { InboxComponent } from './components/inbox/inbox.component';
import { ExperiencesListComponent } from './components/experiences/experiences-list/experiences-list.component';
import { SaveExperienceComponent } from './components/experiences/save-experience/save-experience.component';
import { ExperienceViewComponent } from './components/experiences/experience-view/experience-view.component';
import { MessageViewComponent } from './components/inbox/message-view/message-view.component';
import { NewMessageComponent } from './components/new-message/new-message.component';

const externalUrlProvider = new InjectionToken('externalUrlRedirectResolver');

const routes: Routes = [
  { path: 'apartments', component: ApartmentsListComponent },
  { path: '', component: HomeComponent },
  { path: 'saveapartment', component: SaveApartmentComponent },
  { path: 'scholarships', component: ScholarshipListComponent },
  { path: 'savescholarship', component: SaveScholarshipComponent },
  { path: 'inbox', component: InboxComponent },
  { path : 'experiences', component : ExperiencesListComponent},
  {path : 'saveexperience', component : SaveExperienceComponent},
  {path : 'experience/:id', component : ExperienceViewComponent},
  {path : 'message/:id', component : MessageViewComponent},
  {path : 'newmessage', component : NewMessageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, InjectionToken } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { HeadroomModule } from '@ctrl/ngx-headroom';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { ApartmentsListComponent } from './components/apartments-list/apartments-list.component';
import { FiltersComponent } from './components/filters/filters.component';
import { HttpClientModule } from '@angular/common/http';
import { SaveApartmentComponent } from './components/save-apartment/save-apartment.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { Ng5SliderModule } from 'ng5-slider';
import { PriceSliderComponent } from './components/price-slider/price-slider.component';
import { ScholarshipListComponent } from './components/scholarship-list/scholarship-list.component';
import { ExternalUrlDirective } from './directives/external-url.directive';
import { ActivatedRouteSnapshot } from '@angular/router';
import { SaveScholarshipComponent } from './components/save-scholarship/save-scholarship.component';
import { InboxComponent } from './components/inbox/inbox.component';
import { NewMessageComponent } from './components/new-message/new-message.component';
import { InboxListComponent } from './components/inbox/inbox-list/inbox-list.component';
import { SaveExperienceComponent } from './components/experiences/save-experience/save-experience.component';
import { ExperiencesListComponent } from './components/experiences/experiences-list/experiences-list.component';
import { ExperienceViewComponent } from './components/experiences/experience-view/experience-view.component';
import { MessageViewComponent } from './components/inbox/message-view/message-view.component';

const externalUrlProvider = new InjectionToken('externalUrlRedirectResolver');

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    RegisterComponent,
    LoginComponent,
    ApartmentsListComponent,
    FiltersComponent,
    SaveApartmentComponent,
    PriceSliderComponent,
    ScholarshipListComponent,
    ExternalUrlDirective,
    SaveScholarshipComponent,
    InboxComponent,
    NewMessageComponent,
    InboxListComponent,
    SaveExperienceComponent,
    ExperiencesListComponent,
    ExperienceViewComponent,
    MessageViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HeadroomModule,
    FormsModule,
    HttpClientModule,    
    MDBBootstrapModule.forRoot(),
    Ng5SliderModule,
    ReactiveFormsModule
  ],
  providers: [
    {
      provide: externalUrlProvider,
      useValue: (route: ActivatedRouteSnapshot) => {
          const externalUrl = route.paramMap.get('externalUrl');
          window.open(externalUrl, '_self');
      },
  }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

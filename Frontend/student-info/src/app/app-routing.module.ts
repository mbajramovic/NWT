import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApartmentsListComponent } from './components/apartments-list/apartments-list.component';
import { HomeComponent } from './components/home/home.component';
import { MainPageComponent } from './components/main-page/main-page.component';
import { SaveApartmentComponent } from './components/save-apartment/save-apartment.component';

const routes: Routes = [
  { path: 'apartments', component: ApartmentsListComponent},
  {path: '', component: HomeComponent },
  {path: 'saveapartment', component: SaveApartmentComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

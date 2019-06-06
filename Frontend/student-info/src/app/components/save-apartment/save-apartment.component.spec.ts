import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveApartmentComponent } from './save-apartment.component';

describe('SaveApartmentComponent', () => {
  let component: SaveApartmentComponent;
  let fixture: ComponentFixture<SaveApartmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SaveApartmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SaveApartmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

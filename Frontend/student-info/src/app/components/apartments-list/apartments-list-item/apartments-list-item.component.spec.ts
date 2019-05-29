import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApartmentsListItemComponent } from './apartments-list-item.component';

describe('ApartmentsListItemComponent', () => {
  let component: ApartmentsListItemComponent;
  let fixture: ComponentFixture<ApartmentsListItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApartmentsListItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApartmentsListItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

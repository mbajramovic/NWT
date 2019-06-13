import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveExperienceComponent } from './save-experience.component';

describe('SaveExperienceComponent', () => {
  let component: SaveExperienceComponent;
  let fixture: ComponentFixture<SaveExperienceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SaveExperienceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SaveExperienceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

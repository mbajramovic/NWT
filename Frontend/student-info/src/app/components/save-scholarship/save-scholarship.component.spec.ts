import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveScholarshipComponent } from './save-scholarship.component';

describe('SaveScholarshipComponent', () => {
  let component: SaveScholarshipComponent;
  let fixture: ComponentFixture<SaveScholarshipComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SaveScholarshipComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SaveScholarshipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

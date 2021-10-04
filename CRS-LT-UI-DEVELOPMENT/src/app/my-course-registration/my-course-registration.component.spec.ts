import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyCourseRegistrationComponent } from './my-course-registration.component';

describe('MyCourseRegistrationComponent', () => {
  let component: MyCourseRegistrationComponent;
  let fixture: ComponentFixture<MyCourseRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyCourseRegistrationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyCourseRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

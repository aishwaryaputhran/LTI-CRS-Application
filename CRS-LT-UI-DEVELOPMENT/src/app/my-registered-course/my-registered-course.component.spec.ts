import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyRegisteredCourseComponent } from './my-registered-course.component';

describe('MyRegisteredCourseComponent', () => {
  let component: MyRegisteredCourseComponent;
  let fixture: ComponentFixture<MyRegisteredCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyRegisteredCourseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyRegisteredCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

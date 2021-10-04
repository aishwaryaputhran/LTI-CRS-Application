import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyGradeCardComponent } from './my-grade-card.component';

describe('MyGradeCardComponent', () => {
  let component: MyGradeCardComponent;
  let fixture: ComponentFixture<MyGradeCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyGradeCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyGradeCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

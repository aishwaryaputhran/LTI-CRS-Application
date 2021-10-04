import { TestBed } from '@angular/core/testing';

import { MyStudentServiceService } from './my-student-service.service';

describe('MyStudentServiceService', () => {
  let service: MyStudentServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MyStudentServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { MyUserServiceService } from './my-user-service.service';

describe('MyUserServiceService', () => {
  let service: MyUserServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MyUserServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

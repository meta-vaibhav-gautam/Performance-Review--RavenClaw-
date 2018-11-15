import { TestBed, inject } from '@angular/core/testing';

import { TeamPerformanceService } from './team-performance.service';

describe('TeamPerformanceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TeamPerformanceService]
    });
  });

  it('should be created', inject([TeamPerformanceService], (service: TeamPerformanceService) => {
    expect(service).toBeTruthy();
  }));
});

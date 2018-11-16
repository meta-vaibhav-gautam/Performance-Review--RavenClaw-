import { TestBed, inject } from '@angular/core/testing';

import { ProjectPerformanceService } from './project-performance.service';

describe('ProjectPerformanceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProjectPerformanceService]
    });
  });

  it('should be created', inject([ProjectPerformanceService], (service: ProjectPerformanceService) => {
    expect(service).toBeTruthy();
  }));
});

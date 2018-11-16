import { Injectable } from '@angular/core';
import { ProjectPerformance } from './project-performance';
import { projectPerformanceData } from './project-performance.data';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectPerformanceService {

  constructor() { }

  getProjectPerformanceData(): Observable<ProjectPerformance[]> {
    return of(projectPerformanceData);
  }
}

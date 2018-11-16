import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ProjectPerformance } from '../models/project-performance';
import { projectPerformanceData } from '../../../assets/project-performance.data';

@Injectable({
  providedIn: 'root'
})
export class ProjectPerformanceService {

  constructor() { }

  getProjectPerformanceData(): Observable<ProjectPerformance[]> {
    return of(projectPerformanceData);
  }
}

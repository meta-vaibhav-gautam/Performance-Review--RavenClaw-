import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { TeamPerformance } from './team-performance';
import { temperformanceData } from './team-performance.data';

@Injectable({
  providedIn: 'root'
})
export class TeamPerformanceService {

  constructor() { }

getTeamPerformanceData(): Observable<TeamPerformance[]> {
  return of(temperformanceData);
}

}

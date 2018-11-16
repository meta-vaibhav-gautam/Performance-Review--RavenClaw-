import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { TeamPerformance } from '../models/team-performance';
import { temperformanceData } from '../../../assets/team-performance.data';

@Injectable({
  providedIn: 'root'
})
export class TeamPerformanceService {

  constructor() { }

getTeamPerformanceData(): Observable<TeamPerformance[]> {
  return of(temperformanceData);
}

}

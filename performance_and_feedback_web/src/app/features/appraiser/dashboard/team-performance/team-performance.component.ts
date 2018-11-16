import { Component, OnInit } from '@angular/core';
import { TeamPerformanceService } from './team-performance.service';
import { TeamPerformance } from './team-performance';

@Component({
  selector: 'app-team-performance',
  templateUrl: './team-performance.component.html',
  styleUrls: ['./team-performance.component.css']
})
export class TeamPerformanceComponent implements OnInit {

  isSelectAll: boolean;
  selectedValues: string[] = [];
  teamPerformaceTableData: any[];

  constructor(private teamPerformanceDataService: TeamPerformanceService) { }

  ngOnInit() {
    this.getTeamPerformanceData();
  }
  
  getTeamPerformanceData() {
    this.teamPerformanceDataService.getTeamPerformanceData()
      .subscribe(response => this.teamPerformaceTableData = response);
  }

  selectAll() {
    if (this.isSelectAll) {
      this.selectedValues = [];
      this.teamPerformaceTableData.map((item) => this.selectedValues.push(item.empId));
    } else {
      this.selectedValues = [];
    }
  }

}

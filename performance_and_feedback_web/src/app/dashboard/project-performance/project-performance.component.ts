import { Component, OnInit } from '@angular/core';
import { ProjectPerformanceService } from './project-performance.service';
import { ProjectPerformance } from './project-performance';

@Component({
  selector: 'app-project-performance',
  templateUrl: './project-performance.component.html',
  styleUrls: ['./project-performance.component.css']
})
export class ProjectPerformanceComponent implements OnInit {

  projectPerformaceTableData: ProjectPerformance[];

  constructor(
    private projectPerformanceDataService : ProjectPerformanceService
  ) { }

  ngOnInit() {
    this.getProjectPerformanceData();
  }

  getProjectPerformanceData() {
    this.projectPerformanceDataService.getProjectPerformanceData()
      .subscribe(response => this.projectPerformaceTableData = response);
  }

}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-team-performance',
  templateUrl: './team-performance.component.html',
  styleUrls: ['./team-performance.component.css']
})
export class TeamPerformanceComponent implements OnInit {

  isSelectAll: boolean;
  selectedValues: string[] = [];
  teamPerformaceTableData: any[];

  constructor() { }

  ngOnInit() {
    this.teamPerformaceTableData = [
      { empId: 'E01/1000', name: 'Amit', project: 'Eci', year: '2018', quarter: 'Q1', status: 'Active', lastUpdated: '' },
      { empId: 'E01/1001', name: 'Yash', project: 'Eci', year: '2017', quarter: 'Q1', status: 'Locked', lastUpdated: '' },
      { empId: 'E01/1003', name: 'Amit', project: 'Eci', year: '2018', quarter: 'Q1', status: 'Active', lastUpdated: '' },
      { empId: 'E01/1004', name: 'Yash', project: 'Eci', year: '2017', quarter: 'Q1', status: 'Locked', lastUpdated: '' },
    ];
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

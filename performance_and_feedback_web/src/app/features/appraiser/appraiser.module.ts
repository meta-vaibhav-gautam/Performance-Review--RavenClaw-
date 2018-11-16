import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TeamPerformanceComponent } from './dashboard/team-performance/team-performance.component';
import { ProjectPerformanceComponent } from './dashboard/project-performance/project-performance.component';
import { SideBarComponent } from './side-bar/side-bar.component';
import { AppraiserViewComponent } from './appraiser-view/appraiser-view.component';
import { OrganisationalComponent } from './appraiser-view/organisational/organisational.component';
import { ProjectIndicatorsComponent } from './appraiser-view/project-indicators/project-indicators.component';
import { SelfDevelopmentComponent } from './appraiser-view/self-development/self-development.component';
import { PrimeNgModule } from './prime-ng/prime-ng.module';
import { FormsModule } from '@angular/forms';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import {UIRouterModule} from "@uirouter/angular";


@NgModule({
  imports: [
    CommonModule,
    PrimeNgModule,
    FormsModule,
    Ng2SearchPipeModule,
    UIRouterModule
  ],
  exports: [
    FormsModule
  ],
  declarations: [DashboardComponent, TeamPerformanceComponent, ProjectPerformanceComponent, SideBarComponent, AppraiserViewComponent, OrganisationalComponent, ProjectIndicatorsComponent, SelfDevelopmentComponent]
})
export class AppraiserModule { }

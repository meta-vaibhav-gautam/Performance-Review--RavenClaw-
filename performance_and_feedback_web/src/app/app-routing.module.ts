import { NgModule } from '@angular/core';
import { UIRouterModule } from '@uirouter/angular';
import { RouterModule } from '@angular/router';

import { ROUTE_STATES } from './router.states';
import { routerConfigFn } from './router.config';

@NgModule({
  imports: [
  UIRouterModule.forRoot({
    states: ROUTE_STATES,
    otherwise: { state: 'app.welcome.home' },
    config: routerConfigFn
  }),
],
  exports: [UIRouterModule, RouterModule]
})
export class AppRoutingModule { }

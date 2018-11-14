import { Injectable } from '@angular/core';
import { TransitionService, ResolveContext } from '@uirouter/core';

@Injectable({
  providedIn: 'root',
})
export class RouteInterceptor {
  constructor() { }

  public register(transitionService: TransitionService) {
    // Register transition hooks here
  }

}

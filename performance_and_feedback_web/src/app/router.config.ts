import { UIRouter, Category, ResolveContext } from '@uirouter/core';
import { RouteInterceptor } from './_helpers/route.interceptor'
import { Injector } from '@angular/core';
//import { Visualizer } from '@uirouter/visualizer';

export function routerConfigFn(router: UIRouter, injector: Injector) {

  const transitionService = router.transitionService;

  // console.log("MyTrans", router, transitionService)

  // TRANSITION HOOKS
  let routeInterceptor = injector.get(RouteInterceptor)
  routeInterceptor.register(transitionService)

  router.trace.enable(Category.TRANSITION);
  //router.plugin(Visualizer);
}

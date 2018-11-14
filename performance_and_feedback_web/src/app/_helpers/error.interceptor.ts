import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

import { AuthenticationService } from '../_services/authentication.service';
import { CookieService } from '../_services/cookie.service';
import { StateService } from '@uirouter/core';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
  constructor(private authenticationService: AuthenticationService,
    private cookieService: CookieService,
    private state: StateService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(catchError(err => {
      if (err.status === 401) {
        this.cookieService.clearCookies();
        this.state.go('app.welcome.home')
      }
      return throwError(err);
    }))
  }
}

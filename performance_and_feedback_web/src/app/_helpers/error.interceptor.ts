import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { StateService } from '@uirouter/core';
import { AuthenticationService } from 'src/app/shared/services/authentication.service';
import { CookieService } from 'src/app/shared/services/cookie.service';

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

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { throwError } from 'rxjs';
import { tap, catchError, delay, map } from 'rxjs/operators';
import { CookieService } from '../_services/cookie.service';
import { environment } from '../../environments/environment';
import { StateService } from '@uirouter/core';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
  constructor(private http: HttpClient,
    private cookieService: CookieService,
    private state: StateService) { }

  public currentUser() {
    let id = this.cookieService.getCookie('resource_id')
    return this.http.get<any>(environment.userInfoUrl, {params: { "doIntercept": "false"}})
      .pipe(
        tap((user: any) => {
          console.log('User Fetched', user)
        }), catchError(err => {
          this.cookieService.clearCookies()
          this.state.go('app.welcome.home')
          return throwError(err);
        })
      );
  }

}

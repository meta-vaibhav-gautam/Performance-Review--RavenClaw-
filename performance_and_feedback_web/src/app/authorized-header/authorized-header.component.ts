import { Component, OnInit, Input } from '@angular/core';
import { environment } from '../../environments/environment';
import { CookieService } from '../shared/services/cookie.service';

@Component({
  selector: 'app-authorized-header',
  templateUrl: './authorized-header.component.html',
  styleUrls: ['./authorized-header.component.css']
})
export class AuthorizedHeaderComponent implements OnInit {

  @Input() user;

  constructor(private cookieService: CookieService) { }

  ngOnInit() {
  }

  signOut() {
    this.cookieService.clearCookies();
    localStorage.clear();
    window.location.href = environment.wso2Logout + '?redirect_uri=' + window.location.origin + "/logout";
  }

}

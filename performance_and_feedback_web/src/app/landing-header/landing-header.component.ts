import { Component, OnInit, Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-landing-header',
  templateUrl: './landing-header.component.html',
  styleUrls: ['./landing-header.component.css']
})
export class LandingHeaderComponent implements OnInit {

  public login_email: string;

  constructor(@Inject(DOCUMENT) private document: any) { }

  ngOnInit() {
  }

  public authenticate(form) {
    if (form.invalid) {
      return;
    }
    window.location.href = environment.accServLogin + "?email=" + encodeURIComponent(this.login_email) + "&client_id=" + environment.client_id;
  }

}

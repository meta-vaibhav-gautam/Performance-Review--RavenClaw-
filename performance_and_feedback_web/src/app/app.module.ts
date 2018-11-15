import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PrimeNgModule } from './prime-ng/prime-ng.module';
import { NgProgressModule } from '@ngx-progressbar/core';
import { NgProgressHttpModule } from '@ngx-progressbar/http';
import { ToasterModule } from 'angular2-toaster';
import { RequestInterceptor } from './_helpers/request.interceptor';
import { ErrorInterceptor } from './_helpers/error.interceptor';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { LandingHeaderComponent } from './landing-header/landing-header.component';
import { AuthorizedComponent } from './authorized/authorized.component';
import { AuthorizedHeaderComponent } from './authorized-header/authorized-header.component';
import { FooterComponent } from './footer/footer.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { SideBarComponent } from './side-bar/side-bar.component';
import { AppraiserViewComponent } from './appraiser-view/appraiser-view.component';
import { SelfDevelopmentComponent } from './self-development/self-development.component';
import { OrganisationalComponent } from './organisational/organisational.component';
import { ProjectIndicatorsComponent } from './project-indicators/project-indicators.component';
import {UIRouterModule} from "@uirouter/angular";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LandingHeaderComponent,
    AuthorizedComponent,
    AuthorizedHeaderComponent,
    FooterComponent,
    SideBarComponent,
    AppraiserViewComponent,
    SelfDevelopmentComponent,
    OrganisationalComponent,
    ProjectIndicatorsComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgProgressModule.forRoot(),
    NgProgressHttpModule.forRoot(),
    ToasterModule.forRoot(),
    AppRoutingModule,
    AngularFontAwesomeModule,
    PrimeNgModule,

  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: RequestInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

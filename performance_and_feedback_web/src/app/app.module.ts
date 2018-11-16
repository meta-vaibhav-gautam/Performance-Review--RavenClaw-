import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

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
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import {UIRouterModule} from "@uirouter/angular";

//appraiser module import
import { AppraiserModule } from './features/appraiser/appraiser.module';

//module for primeNG components
import { PrimeNgModule } from './features/appraiser/prime-ng/prime-ng.module';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LandingHeaderComponent,
    AuthorizedComponent,
    AuthorizedHeaderComponent,
    FooterComponent
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
    AppraiserModule,
    PrimeNgModule,
    Ng2SearchPipeModule,
    UIRouterModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: RequestInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

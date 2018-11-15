import { Transition } from '@uirouter/core';

import { CookieService } from './_services/cookie.service';
import { AuthenticationService } from './_services/authentication.service';

import { HomeComponent } from './home/home.component';
import { AuthorizedComponent } from './authorized/authorized.component';
import { AuthorizedHeaderComponent } from './authorized-header/authorized-header.component';
import { LandingHeaderComponent } from './landing-header/landing-header.component';
import { FooterComponent } from './footer/footer.component';
import { SideBarComponent } from './side-bar/side-bar.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AppraiserViewComponent } from './appraiser-view/appraiser-view.component';

// Check for session
function isAuthenticated(access_token) {
  let cookieService = new CookieService;
  if(!access_token)
    access_token = cookieService.getCookie('access_token')
  if (access_token)
    return setProviderId(access_token, cookieService);
}

function setProviderId(access_token, cookieService) {
  cookieService.setCookie('access_token', access_token)
  return true;
}

export function checkSession(trans: Transition) {
  let access_token = trans.params().access_token
  let goTo = trans.params().goTo || 'app.authorized.home'
  let loggedIn = isAuthenticated(access_token)
  let redirectTo = loggedIn ? trans.router.stateService.go(goTo) : true;
  return redirectTo;
}

// Resolve Functions
export function resolveUser(user: AuthenticationService) {
  return user.currentUser().toPromise();
}

export function resolveOrgId(user) {
  return user.organization_id
}


// This is the parent state for the entire application.
export const appState = {
  name: 'app',
  abstract: true
}

// States for Unauthenticated Users
export const welcomeState = {
  name: 'app.welcome',
  abstract: true,
  views: {
    'header@^.^': { component: LandingHeaderComponent },
    'footer@^.^': { component: FooterComponent },
  }
};

export const homeState = {
  name: 'app.welcome.home',
  url: '/',
  views: {
    '@': { component: HomeComponent },
  },
  resolve: [
    { token: 'checkSession', deps: [Transition], resolveFn: checkSession }
  ]
};

export const logoutState = {
  name: 'app.welcome.logout',
  url: '/logout',
  views: {
    '@': { component: HomeComponent },
  }
};


// States for Authenticated Users
export const authorizedState = {
  name: 'app.authorized',
  abstract: true,
  views: {
    'header@^.^': { component: AuthorizedHeaderComponent },
    '@': { component: AuthorizedComponent },
    'nav@^.^': { component: SideBarComponent },
    // 'footer@^.^': { component: FooterComponent },
  },
  resolve: [
    { token: 'user', deps: [AuthenticationService], resolveFn: resolveUser },
    { token: 'organization_id', deps: ['user'], resolveFn: resolveOrgId }
  ]
};

// IMPORTANT
// This is an example authorized state
// Delete this or change it's component once you start implementing your own states
export const authorizedHomeState = {
  name: 'app.authorized.home',
  url: '/',
  views: {
    // 'header@^.^': { component: AuthorizedHeaderComponent },
    '@': { component: DashboardComponent }
  },
  resolve: [
  ]
};

export const authorizedAppraiserViewState = {
  name: 'app.authorized.appraiser-view',
  url: '/appraiser-view',
  views: {
    // 'header@^.^': { component: AuthorizedHeaderComponent },
    '@': { component: AppraiserViewComponent }
  },
  resolve: [
  ]
};

export const ROUTE_STATES = [
  appState,
  welcomeState,
  homeState,
  logoutState,
  authorizedState,
  authorizedHomeState,
  authorizedAppraiserViewState
];

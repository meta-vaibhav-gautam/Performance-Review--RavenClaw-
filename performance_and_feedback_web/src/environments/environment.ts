// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  apiUrl: "http://localhost:8080/api/v1/",
  wso2Login: "https://ec2-34-220-78-195.us-west-2.compute.amazonaws.com:9443/oauth2/authorize?client_id=8UYISLap4HQ94bOpkgK2s_RBORUa&response_type=code&fidp=googledev&scope=openid&redirect_uri=http://localhost:3000/sessions&state=eydzaXRlX3VybCc6ICdodHRwOi8vbG9jYWxob3N0OjQxMDAvJ30=",
  accServLogin: "http://localhost:8080/login",
  client_id: "222",
  wso2Logout: "http://localhost:3000/logout",
  resourceUrl: "http://localhost:3100",
  userInfoUrl: "http://dev-services.agilestructure.in/api/v1/sessions/current.json"
};

/*
 * In development mode, to ignore zone related error stack frames such as
 * `zone.run`, `zoneDelegate.invokeTask` for easier debugging, you can
 * import the following file, but please comment it out in production mode
 * because it will have performance impact when throw error
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.

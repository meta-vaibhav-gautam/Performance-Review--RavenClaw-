import{Injectable}from'@angular/core';import{HttpRequest,HttpHandler,HttpEvent,HttpInterceptor}from'@angular/common/http';import{Observable}from'rxjs';import{environment}from'../../environments/environment';import{CookieService}from'../_services/cookie.service';

@Injectable()
export class RequestInterceptor implements HttpInterceptor {
	constructor(private cookieService: CookieService) { }
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // add authorization header with jwt token if available
    let authorization = this.cookieService.getCookie('access_token');
    let contentType = "application/json";
    let doIntercept = true;
    	if(request.params.get('doIntercept') != "undefined" )	{
    		doIntercept = request.params.get('doIntercept')=='true';
    	}
    let httpHeaderOptions = {
      'Authorization': authorization,
      'Content-Type': contentType
    };
    let apiUrl =""
    if(doIntercept) {
    apiUrl = environment.apiUrl;
    }

    request = request.clone({
      setHeaders: httpHeaderOptions,
      url: apiUrl + request.url
    });
    // console.log("Req", request);

    return next.handle(request);
  }
}

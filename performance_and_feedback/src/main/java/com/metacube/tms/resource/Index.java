/**
 * 
 */
package com.metacube.tms.resource;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.tms.config.AppConfiguration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Yash Sharma<yash.sharma@metacube.com>
 * @since 21-Sep-2018
 */

@Slf4j
@RestController
@Api("index file")
public class Index {
  @Autowired
  private AppConfiguration config;

  @Value("${ui.base_url}")
  private String base_url;

  /**
   * 
   * @return
   * @throws IOException
   */
  @GetMapping("/")
  @ApiOperation("Returns list of all Employees in the system.")
  public void findAll(HttpServletResponse model, Principal principal) {
    OAuth2Authentication auth = (OAuth2Authentication) principal;
    String access_token = OAuth2AuthenticationDetails.class.cast(auth.getDetails()).getTokenValue();
    model.setHeader("Location", base_url + "/?access_token=" + access_token);
    model.setHeader("Set-Cookie", "access_token=" + access_token);
    model.setStatus(302);
  }

//  TODO: Remove
  @GetMapping("/user")
  public Object user(Principal principal) {
    System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }

//  NOTE: Allow all OPTIONS CALL
  /*@CrossOrigin
  @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
  public ResponseEntity handle() {
    return new ResponseEntity(HttpStatus.OK);
  }*/

  @DeleteMapping("/app/logout")
  public String logoutPage(HttpServletRequest request, HttpServletResponse response)
      throws URISyntaxException, ClientProtocolException, IOException {
    try {
      String token = request.getHeader("Authorization");
      URI uri = new URIBuilder().setScheme(config.getSso().getScheme()).setHost(config.getSso().getHost())
          .setPath(config.getSso().getPath()).build();
      HttpPost httppost = new HttpPost(uri);

      httppost.setHeader("Accept", "application/json");
      httppost.setHeader("Content-type", "application/json");
      httppost.setHeader("Authorization", token);
      CloseableHttpClient httpClient = HttpClients.createDefault();
      CloseableHttpResponse res = httpClient.execute(httppost);
      HttpEntity entity = res.getEntity();

//      TODO: To be used with TokenStore
//      String authHeader = request.getHeader("Authorization");
//      if (authHeader != null) {
//          String tokenValue = authHeader.replace("Bearer", "").trim();
//          OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
//          tokenStore.removeAccessToken(accessToken);
//      }

    } catch (URISyntaxException e) {
      System.out.println("*************catch*********" + e);
    }

    return "";
  }

}


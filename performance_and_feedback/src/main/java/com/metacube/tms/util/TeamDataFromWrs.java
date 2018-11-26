package com.metacube.tms.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import com.metacube.tms.entity.Employee;

public class TeamDataFromWrs {

public static String getEmployeeById(int id) {
Employee employee = null ;
try {
OAuth2Authentication oAuth2Authentication= (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();

URL url = new URL(
"http://dev-services.agilestructure.in/api/v1/employees/"
+ id + ".json?id=" + id + "&sso_enabled=true");

HttpURLConnection con = (HttpURLConnection) url.openConnection();

String access_token = OAuth2AuthenticationDetails.class.cast(
oAuth2Authentication.getDetails()).getTokenValue();

con.setRequestProperty("Content-Type", "application/json");
con.setRequestProperty("Authorization", access_token);
con.setRequestMethod("GET");

int status = con.getResponseCode();
System.out.println("Status---" + status);

BufferedReader in = new BufferedReader(new InputStreamReader(
con.getInputStream()));
String inputLine;
StringBuffer content = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
content.append(inputLine);
}
/*
JSONObject jsonObject = new JSONObject(content.toString());
System.out.println("object:----" + jsonObject);
employee = new Employee((Long) jsonObject.getLong("id"),
(String) jsonObject.getString("full_name"),
(String) jsonObject.getString("email"));
in.close();
*/
} catch (Exception e) {

}
return "123";
}

}


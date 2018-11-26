package com.metacube.tms.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

/**
 * Class to Find the name of the Employee from ID in WRS
 */
public class WRSFullNameExtractor {
	public static String getEmployeeNameById(long userId) {
		String employeeFullName = null;
		try {
			OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext()
					.getAuthentication();

			URL url = new URL("http://dev-services.agilestructure.in/api/v1/employees/" + userId + ".json?id=" + userId
					+ "&sso_enabled=true");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			String access_token = OAuth2AuthenticationDetails.class.cast(oAuth2Authentication.getDetails())
					.getTokenValue();

			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Authorization", access_token);
			con.setRequestMethod("GET");

			int status = con.getResponseCode();
			System.out.println("Status---" + status);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}

			JSONObject jsonObject = new JSONObject(content.toString());
			employeeFullName = (String) jsonObject.getString("full_name");
			in.close();

		} catch (Exception e) {

		}
		return employeeFullName;
	}
}

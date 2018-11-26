package com.metacube.tms.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.Beta;
import com.metacube.tms.modal.EmployeeModal;

/**
 * Contains utility methods to get employee information from WRS API
 * 
 * @author Pratiksha Jain
 *
 */
@Service
public class WRSAPIUtils {

	/**
	 * returns JSON Array of all employees in system
	 * 
	 * @return
	 */
	private static JSONArray getListOfEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://dev-services.agilestructure.in/api/v1/employees.json/?per=10000&page=1&sso_enabled=true";
		OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder
				.getContext().getAuthentication();
		String access_token = OAuth2AuthenticationDetails.class
				.cast(oAuth2Authentication.getDetails()).getTokenValue();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.add("Authorization", access_token);
		HttpEntity<String> entity = new HttpEntity<>("parameters", header);
		ResponseEntity<String> response = restTemplate.exchange(url,
				HttpMethod.GET, entity, String.class);
		JSONArray jsonArray = null;
		try {
			JSONObject jsonObject = new JSONObject(response.getBody());
			jsonArray = jsonObject.getJSONArray("employees");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonArray;
	}

	/**
	 * returns total number of employees in system
	 * 
	 * @return
	 */
	public static Integer getTotalEmployees() {
		JSONArray jsonArray = getListOfEmployee();
		System.out.println("Employee count  " + jsonArray.length());
		return jsonArray.length();
	}

	public static List<EmployeeModal> getEmployeeDetails() {
		JSONArray jsonArray = getListOfEmployee();
		List<EmployeeModal> listOfEmployeeDetails = new ArrayList<>();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject;
			try {
				jsonObject = jsonArray.getJSONObject(i);
				EmployeeModal employeeModal = new EmployeeModal();
				employeeModal.setId(jsonObject.getLong("id"));
				employeeModal.setEmail(jsonObject.getString("email"));
				employeeModal.setOrgId(jsonObject.getLong("organization_id"));
//				employeeModal.setManagerUid(jsonObject.getLong("manager_id"));
//				employeeModal.setNormalizerUid(jsonObject.getLong("skip_manager_id"));
				listOfEmployeeDetails.add(employeeModal);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		System.out.println(listOfEmployeeDetails.toString());
		return listOfEmployeeDetails;
	}
}

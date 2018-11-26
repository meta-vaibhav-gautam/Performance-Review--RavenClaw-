package com.metacube.tms.resource.appraise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.tms.modal.appraise.UserPerformanceFeedbackFormModel;
import com.metacube.tms.service.appraise.DashboardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * Controller class for data for dashboard
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/dashboard")
@Api("Dashboard of appraise.")
public class DashboardResource {
	@Autowired
	DashboardService dashboardService;

	/**
	 * method to get all the performance feedback form of user.
	 * 
	 * @param id
	 *            id of user of which forms to be published
	 * @return performance feedback forms of user
	 */
	@GetMapping("/dashboard/{id}")
	@ApiOperation("Returns list of all forms of the user.")
	public List<UserPerformanceFeedbackFormModel> getUserPerformanceFeedbackForm(@PathVariable long id) {
		List<UserPerformanceFeedbackFormModel> data = dashboardService.getUserDetailsById(id);
		return data;
	}
}

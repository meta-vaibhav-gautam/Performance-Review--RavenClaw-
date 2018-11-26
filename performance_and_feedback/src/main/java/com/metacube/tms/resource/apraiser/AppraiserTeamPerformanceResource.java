package com.metacube.tms.resource.apraiser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.tms.modal.TeamPerformanceModal;
import com.metacube.tms.service.appraiser.AppraiserTeamPerformanceService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping(value = "/api/v1/appraiser")
public class AppraiserTeamPerformanceResource {
	
	@Autowired
	private AppraiserTeamPerformanceService appraiserTeamPerformanceService;
	
	@GetMapping("/teamData")
	public List<TeamPerformanceModal> getTeamPerformanceDashboardData() {
		return appraiserTeamPerformanceService.getTeamPerformanceDashboardData();
	}
}

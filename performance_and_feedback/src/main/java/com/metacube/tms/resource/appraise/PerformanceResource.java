package com.metacube.tms.resource.appraise;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.metacube.tms.modal.appraise.DropdownModel;
import com.metacube.tms.modal.appraise.KeyPerformanceIndicatorsMasterModel;
import com.metacube.tms.service.appraise.PerformanceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/performance")
@Api("Performance tab view")
public class PerformanceResource {
	@Autowired
	PerformanceService performanceService;

	@GetMapping("/getKeyPerformanceIndicator")
	@ApiOperation("Returns list of all key performance indicator.")
	public List<KeyPerformanceIndicatorsMasterModel> getKeyPerformanceIndicatorsMaster() {
		return performanceService.getKeyPerformanceIndicatorsMasterData();
	}

	@GetMapping("/{id}")
	@ApiOperation("Return dropdown data of key indicators.")
	public List<DropdownModel> getDropdownData(@PathVariable long id) {
		return performanceService.getDropDownData(id);
	}

	@GetMapping("/getTimeline/{id}")
	@ApiOperation("Return timeline dropdown data.")
	public List<DropdownModel> getTimeline(@PathVariable long id) {
		return performanceService.getTimeline(id);
	}

}

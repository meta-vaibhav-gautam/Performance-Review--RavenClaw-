package com.metacube.tms.resource.appraise;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.tms.modal.appraise.AppraiseDataKeyIndicatorModel;
import com.metacube.tms.modal.appraise.AppraiseDataModel;
import com.metacube.tms.service.appraise.SummaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/summary")
@Api("Summary of appraise.")
public class SummaryResource {

	@Autowired
	SummaryService summaryService;

	@GetMapping(value = "/{id}")
	@ApiOperation("get summary of appraise")
	public Map<Long, AppraiseDataKeyIndicatorModel> getSummaryData(@PathVariable long id) {
		List<AppraiseDataModel> appraiseDataModel = summaryService.getSummaryData(id);
		Map<Long, AppraiseDataKeyIndicatorModel> appraiseDataKeyIndicatorModelMap = summaryService
				.getAppraiseDataByKeyIndicator(appraiseDataModel);
		System.out.println(appraiseDataModel);

		return appraiseDataKeyIndicatorModelMap;
	}

}

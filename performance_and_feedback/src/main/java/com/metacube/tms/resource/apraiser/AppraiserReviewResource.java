package com.metacube.tms.resource.apraiser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.tms.entity.KeyPerformanceIndicatorsLabels;
import com.metacube.tms.entity.KeyPerformanceIndicatorsMaster;
import com.metacube.tms.entity.UserPerformanceData;
import com.metacube.tms.modal.UserPerformanceDataModel;
import com.metacube.tms.service.appraiser.impl.AppraiserReviewServiceImpl;

@RestController
@RequestMapping(value = "/api/v1/appraiser")
public class AppraiserReviewResource {

	@Autowired
	private AppraiserReviewServiceImpl appraiserReviewServiceImpl;

	/*@GetMapping("/projectIndicators/labels")
	public List<KeyPerformanceIndicatorsLabels> getProjectIndicatorsLabels() {
		return appraiserReviewServiceImpl.getProjectPerformanceIndicatorsLabels();
	}

	@GetMapping("/organisationalDevelopment/labels")
	public List<KeyPerformanceIndicatorsMaster> getOrganisationalDevelopmentLabels() {
		return appraiserReviewServiceImpl.getOrganisationalDevelopmentLabels();
	}

	@GetMapping("/subLabels/{id}")
	public List<KeyPerformanceIndicatorsLabels> getSubLabels(@PathVariable("id") long id) {
		return appraiserReviewServiceImpl.getSubLabels(id);
	}*/

	@GetMapping("/performance/data/{userPerformanceFeedbackFormId}/{keyPerformanceGroupMasterName}")
	public List<UserPerformanceDataModel> getPerformanceData(
			@PathVariable("userPerformanceFeedbackFormId") Long userPerformanceFeedbackFormId,
			@PathVariable("keyPerformanceGroupMasterName") String keyPerformanceGroupMasterName) {
		return appraiserReviewServiceImpl.getPerformanceData(userPerformanceFeedbackFormId,
				keyPerformanceGroupMasterName);
	}
	
	@PutMapping("/performance/{userPerformanceFeedbackFormId}/save")
	public List<UserPerformanceData> saveReview(
			@PathVariable("userPerformanceFeedbackFormId") Long userPerformanceFeedbackFormId,
			@RequestBody List<UserPerformanceDataModel> userPerformanceDataModelList) {
		System.out.println(userPerformanceDataModelList.toString());
		return appraiserReviewServiceImpl.saveReview(userPerformanceFeedbackFormId, userPerformanceDataModelList);
	}
}

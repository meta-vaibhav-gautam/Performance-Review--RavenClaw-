/**
 * 
 */
package com.metacube.tms.resource.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.tms.entity.PerformanceFeedbackForm;
import com.metacube.tms.modal.CurrentUser;
import com.metacube.tms.modal.PerformanceFeedbackFormModel;
import com.metacube.tms.service.admin.PerformanceFeedbackFormService;
import com.metacube.tms.util.CollectionUtils;
import com.metacube.tms.util.WRSAPIUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author User22
 *
 */
@RestController
@RequestMapping("api/v1/performance-feedback-form")
@Api("Set of endpoints Creating, Retrieving, Updating and Deleting Performance Feedback Forms.")
public class PerfomanceFeedbackFormResource {

	@Autowired
	private PerformanceFeedbackFormService performanceFeedbackFormService;
	private static final String DOZER_MAPPING_PATH = "file:/performance_and_feedback/src/main/resources/dozer_mapping.xml";

	@GetMapping("get-all-forms")
	@ApiOperation("Returns list of all performance feedback forms")
	public ResponseEntity<Collection<PerformanceFeedbackFormModel>> getAllForms(
			@AuthenticationPrincipal CurrentUser currentUser) {

		Collection<PerformanceFeedbackForm> forms = CollectionUtils
				.iterableToCollection(performanceFeedbackFormService
						.getAllForms(currentUser.getOrganizationID()));

		if (forms.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		DozerBeanMapper mapper = new DozerBeanMapper();

		mapper.setMappingFiles(Arrays.asList(DOZER_MAPPING_PATH));

		Collection<PerformanceFeedbackFormModel> feedbackFormList = new ArrayList<>();

		forms.forEach(form -> {
			PerformanceFeedbackFormModel feedbackFormModel = mapper.map(form,
					PerformanceFeedbackFormModel.class);
			feedbackFormModel.setTotalEmployees(WRSAPIUtils.getTotalEmployees());
			feedbackFormList.add(feedbackFormModel);
		});

		return new ResponseEntity<Collection<PerformanceFeedbackFormModel>>(
				feedbackFormList, HttpStatus.OK);
	}

}

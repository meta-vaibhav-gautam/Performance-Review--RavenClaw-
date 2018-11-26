package com.metacube.tms.service.appraise.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.tms.entity.EvaluationDurationMaster;
import com.metacube.tms.entity.PerformanceFeedbackForm;
import com.metacube.tms.entity.UserPerformanceFeedbackForm;
import com.metacube.tms.modal.appraise.UserPerformanceFeedbackFormModel;
import com.metacube.tms.repository.appraise.UserPerformanceFeedbackFormRepository;
import com.metacube.tms.service.appraise.DashboardService;
import com.metacube.tms.util.WRSFullNameExtractor;

/**
 * 
 * class for Dashboard Service Implementation
 *
 */
@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private UserPerformanceFeedbackFormRepository userPerformanceFeedbackFormRepository;

	public List<UserPerformanceFeedbackFormModel> getUserDetailsById(long userId) {

		List<UserPerformanceFeedbackForm> userPerformanceFeedbackForm;
		PerformanceFeedbackForm performanceFeedbackForm;
		EvaluationDurationMaster evaluationDurationMaster;
		List<UserPerformanceFeedbackFormModel> dashboardDataList = new ArrayList<>();

		userPerformanceFeedbackForm = userPerformanceFeedbackFormRepository.findByuserUid(userId);

		// loop for entring data in Dashboard
		for (UserPerformanceFeedbackForm userData : userPerformanceFeedbackForm) {
			UserPerformanceFeedbackFormModel dashboardData = new UserPerformanceFeedbackFormModel();
			String managerName, normalizerName;
			performanceFeedbackForm = userData.getPerformanceFeedbackFormId();
			evaluationDurationMaster = performanceFeedbackForm.getUserPerfEvaluationDurationMaster();

			dashboardData.setId(performanceFeedbackForm.getId());
			dashboardData.setYear(performanceFeedbackForm.getYear());
			dashboardData.setQuarter(evaluationDurationMaster.getTitle());
			dashboardData.setStatus(userData.getStatus().name());

			// getting manager and normalizer
			managerName = WRSFullNameExtractor.getEmployeeNameById(userData.getManagerUid());
			normalizerName = WRSFullNameExtractor.getEmployeeNameById(userData.getNormalizerUid());

			// setting manager name and normalizer
			dashboardData.setManagerName(managerName);
			dashboardData.setNormaliserName(normalizerName);

			// getting publish date and last updated date
			Date publishDate = performanceFeedbackForm.getPublishDate();
			Date lastUpdatedDate = userData.getLastModifiedDate();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

			try {
				// Setting public date and last updated date
				dashboardData.setPublishDate(simpleDateFormat.format(publishDate));
				dashboardData.setLastUpdatedDate(simpleDateFormat.format(lastUpdatedDate));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			dashboardDataList.add(dashboardData);
		}
		return dashboardDataList;
	}
}

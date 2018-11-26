package com.metacube.tms.service.appraiser.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.tms.DummyUsers.DummyUser;
import com.metacube.tms.DummyUsers.DummyUserFactory;
import com.metacube.tms.entity.EvaluationDurationMaster;
import com.metacube.tms.entity.PerformanceFeedbackForm;
import com.metacube.tms.entity.UserPerformanceData;
import com.metacube.tms.entity.UserPerformanceFeedbackForm;
import com.metacube.tms.entity.enums.PerformanceFeedbackFormStatus;
import com.metacube.tms.modal.TeamPerformanceModal;
import com.metacube.tms.repository.appraise.UserPerformanceDataRepository;
import com.metacube.tms.service.appraiser.AppraiserTeamPerformanceService;

@Service
public class AppraiserTeamPerformanceServiceImpl implements AppraiserTeamPerformanceService {

	@Autowired
	private UserPerformanceDataRepository userPerformanceDataRepository;

	public List<TeamPerformanceModal> getTeamPerformanceDashboardData() {

		EvaluationDurationMaster evaluationDurationMaster;
		UserPerformanceFeedbackForm userPerformanceFeedbackForm;
		PerformanceFeedbackForm performanceFeedbackForm;
		PerformanceFeedbackFormStatus performanceFeedbackFormStatus;
		DummyUserFactory dummyUser = new DummyUserFactory();

		List<TeamPerformanceModal> teamList = new ArrayList<TeamPerformanceModal>();

		for (DummyUser user : dummyUser.dummyUserData) {
			List<UserPerformanceData> userPerformanceDataList = userPerformanceDataRepository
					.findAllByUserUid(user.getUserId());
			Set<Long> evaluationDurationMasterId = new HashSet<Long>();
			Set<Long> userPerformanceFeedbackFormId = new HashSet<Long>();

			for (UserPerformanceData userPerformance : userPerformanceDataList) {
				evaluationDurationMaster = userPerformance.getEvaluationDurationMasterId();
				userPerformanceFeedbackForm = userPerformance.getUserPerformanceFeedbackFormId();

				if (!evaluationDurationMasterId.contains(evaluationDurationMaster.getId())
						&& !userPerformanceFeedbackFormId.contains(userPerformanceFeedbackForm.getId())) {
					evaluationDurationMasterId.add(evaluationDurationMaster.getId());
					userPerformanceFeedbackFormId.add(userPerformanceFeedbackForm.getId());
					String title = evaluationDurationMaster.getTitle();

					performanceFeedbackForm = userPerformanceFeedbackForm.getPerformanceFeedbackFormId();
					performanceFeedbackFormStatus = performanceFeedbackForm.getStatus();
					Date date = performanceFeedbackForm.getLastModifiedDate();
					Integer year = performanceFeedbackForm.getYear();
					teamList.add(
							new TeamPerformanceModal(user.getUserId(), user.getDoj(), user.getEmail(), user.getName(),
									user.getProject(), user.getEmpId(), year, title, performanceFeedbackFormStatus,
									date, evaluationDurationMaster.getId(), userPerformanceFeedbackForm.getId()));
				}
			}
		}
		return teamList;
	}
}

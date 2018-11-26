package com.metacube.tms.service.appraise.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.tms.entity.KeyPerformanceIndicatorsLabels;
import com.metacube.tms.entity.UserPerformanceData;
import com.metacube.tms.entity.UserPerformanceFeedbackForm;
import com.metacube.tms.modal.appraise.AppraiseDataKeyIndicatorModel;
import com.metacube.tms.modal.appraise.AppraiseDataModel;
import com.metacube.tms.modal.appraise.DropdownModel;
import com.metacube.tms.repository.appraise.UserPerformanceDataRepository;
import com.metacube.tms.service.appraise.SummaryService;

@Service
public class SummaryServiceImpl implements SummaryService {

	@Autowired
	UserPerformanceDataRepository userPerformanceDataRepository;

	@Override
	public List<AppraiseDataModel> getSummaryData(long id) {
		List<AppraiseDataModel> appraiseDataModelList = new ArrayList<AppraiseDataModel>();
		UserPerformanceFeedbackForm userPerformanceFeedbackForm = new UserPerformanceFeedbackForm();
		KeyPerformanceIndicatorsLabels keyPerformanceIndicatorsLabels;
		userPerformanceFeedbackForm.setId(id);
		List<UserPerformanceData> userPerformanceDataList = userPerformanceDataRepository
				.findByUserPerformanceFeedbackFormId(userPerformanceFeedbackForm);

		for (UserPerformanceData userPerformanceData : userPerformanceDataList) {
			AppraiseDataModel appraiseDataModel = new AppraiseDataModel();
			AppraiseDataKeyIndicatorModel appraiseDataKeyIndicatorModel = new AppraiseDataKeyIndicatorModel();

			keyPerformanceIndicatorsLabels = userPerformanceData.getKeyPerformanceIndicatorsLabelsId();
			appraiseDataModel.setComment1(userPerformanceData.getComment1());
			appraiseDataModel.setComment2(userPerformanceData.getComment2());
			appraiseDataModel.setTimeSpent(userPerformanceData.getTimeSpent());
			DropdownModel dropdownModel1 = new DropdownModel();
			dropdownModel1.setId(keyPerformanceIndicatorsLabels.getId());
			dropdownModel1.setName(keyPerformanceIndicatorsLabels.getLabel());
			appraiseDataModel.setDropDown(dropdownModel1);
			appraiseDataModel.setId(keyPerformanceIndicatorsLabels.getKeyPerformanceIndicatorsMasterId().getId());
			appraiseDataModelList.add(appraiseDataModel);

			appraiseDataKeyIndicatorModel.setAppraiseDataModelList(appraiseDataModelList);
		}
		return appraiseDataModelList;
	}

	@Override
	public Map<Long, AppraiseDataKeyIndicatorModel> getAppraiseDataByKeyIndicator(
			List<AppraiseDataModel> appraiseDataModelList) {

		Map<Long, AppraiseDataKeyIndicatorModel> appraiseDataKeyIndicatorModelMap = new HashMap<>();

		for (AppraiseDataModel appraiseDataModel : appraiseDataModelList) {
			List<AppraiseDataModel> appraiseDataList = new ArrayList<>();
			long id = appraiseDataModel.getId();

			if (appraiseDataKeyIndicatorModelMap.containsKey(id)) {
				appraiseDataList = appraiseDataKeyIndicatorModelMap.get(id).getAppraiseDataModelList();
				appraiseDataList.add(appraiseDataModel);
				appraiseDataKeyIndicatorModelMap.get(id).setAppraiseDataModelList(appraiseDataList);

			} else {
				appraiseDataList.add(appraiseDataModel);
				AppraiseDataKeyIndicatorModel appraiseDataKeyIndicatorModel = new AppraiseDataKeyIndicatorModel();
				appraiseDataKeyIndicatorModel.setId(id);
				appraiseDataKeyIndicatorModel.setAppraiseDataModelList(appraiseDataList);
				appraiseDataKeyIndicatorModelMap.put(id, appraiseDataKeyIndicatorModel);
			}

		}

		return appraiseDataKeyIndicatorModelMap;
	}

}

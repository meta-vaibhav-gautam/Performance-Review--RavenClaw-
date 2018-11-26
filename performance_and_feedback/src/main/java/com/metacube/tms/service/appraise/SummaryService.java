package com.metacube.tms.service.appraise;

import java.util.List;
import java.util.Map;

import com.metacube.tms.modal.appraise.AppraiseDataKeyIndicatorModel;
import com.metacube.tms.modal.appraise.AppraiseDataModel;

public interface SummaryService {

	List<AppraiseDataModel> getSummaryData(long id);

	Map<Long,AppraiseDataKeyIndicatorModel> getAppraiseDataByKeyIndicator(List<AppraiseDataModel> appraiseDataModelList);

}

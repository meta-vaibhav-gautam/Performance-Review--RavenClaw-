package com.metacube.tms.service.admin;

import java.util.List;

import com.metacube.tms.entity.PerformanceFeedbackForm;
import com.metacube.tms.service.BaseService;

public interface PerformanceFeedbackFormService extends BaseService {

	public Iterable<PerformanceFeedbackForm> getAllForms(Long orgId);

}

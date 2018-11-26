package com.metacube.tms.service.appraise;

import java.util.List;

import com.metacube.tms.modal.appraise.UserPerformanceFeedbackFormModel;

/**
 * 
 * interface for Dashboard Services
 */
public interface DashboardService {
	// Function to get User Details By Id
	public List<UserPerformanceFeedbackFormModel> getUserDetailsById(long userId);
}

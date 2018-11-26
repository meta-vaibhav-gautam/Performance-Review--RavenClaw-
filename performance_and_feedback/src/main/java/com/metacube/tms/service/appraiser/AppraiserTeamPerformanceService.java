package com.metacube.tms.service.appraiser;

import java.util.List;

import com.metacube.tms.modal.TeamPerformanceModal;
import com.metacube.tms.service.BaseService;

public interface AppraiserTeamPerformanceService extends BaseService{
	public List<TeamPerformanceModal> getTeamPerformanceDashboardData();
}

package com.metacube.tms.service.appraise;

import java.util.List;


import com.metacube.tms.modal.appraise.DropdownModel;
import com.metacube.tms.modal.appraise.KeyPerformanceIndicatorsMasterModel;

/**
 * Service for performance tab view
 *
 */
public interface PerformanceService {
	/**
	 * Function to get key performance Indicator Master Data List
	 * 
	 * @return list of Indicator master Data
	 */
	public List<KeyPerformanceIndicatorsMasterModel> getKeyPerformanceIndicatorsMasterData();

	/**
	 * Function to get the specific dropdown by ID
	 * 
	 * @param id
	 * @return List of dropdown specified by Id
	 */
	public List<DropdownModel> getDropDownData(long id);
	
	public List<DropdownModel> getTimeline(long id);
}

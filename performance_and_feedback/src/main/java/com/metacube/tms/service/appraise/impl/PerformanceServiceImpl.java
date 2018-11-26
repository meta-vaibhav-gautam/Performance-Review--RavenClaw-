package com.metacube.tms.service.appraise.impl;

import java.text.Format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.tms.entity.KeyPerformanceIndicatorsLabels;
import com.metacube.tms.entity.KeyPerformanceIndicatorsMaster;
import com.metacube.tms.entity.PerformanceFeedbackForm;
import com.metacube.tms.modal.appraise.DropdownModel;
import com.metacube.tms.modal.appraise.KeyPerformanceIndicatorsMasterModel;
import com.metacube.tms.repository.appraise.KeyPerformanceIndicatorsLabelsRepository;
import com.metacube.tms.repository.appraise.KeyPerformanceIndicatorsMasterRepository;
import com.metacube.tms.repository.appraise.UserPerformanceFeedbackFormRepository;
import com.metacube.tms.service.appraise.PerformanceService;

@Service
public class PerformanceServiceImpl implements PerformanceService {

	@Autowired
	KeyPerformanceIndicatorsMasterRepository keyPerformanceIndicatorsMasterRepository;

	@Autowired
	KeyPerformanceIndicatorsLabelsRepository keyPerformanceIndicatorsLabelsRepository;

	@Autowired
	UserPerformanceFeedbackFormRepository userPerformanceFeedbackFormRepository;

	@Override
	public List<KeyPerformanceIndicatorsMasterModel> getKeyPerformanceIndicatorsMasterData() {
		List<KeyPerformanceIndicatorsMaster> keyPerformanceIndicatorsMasterList;
		List<KeyPerformanceIndicatorsMasterModel> keyPerformanceIndicatorsMasterModelList = new ArrayList<>();
		keyPerformanceIndicatorsMasterList = keyPerformanceIndicatorsMasterRepository.findAll();

		for (KeyPerformanceIndicatorsMaster data : keyPerformanceIndicatorsMasterList) {
			KeyPerformanceIndicatorsMasterModel keyPerformanceIndicatorsMasterModel = new KeyPerformanceIndicatorsMasterModel();
			keyPerformanceIndicatorsMasterModel.setId(data.getId());
			keyPerformanceIndicatorsMasterModel.setName(data.getName());
			keyPerformanceIndicatorsMasterModel.setDescription(data.getDescription());
			keyPerformanceIndicatorsMasterModel.setLabel(data.getLabel());

			keyPerformanceIndicatorsMasterModelList.add(keyPerformanceIndicatorsMasterModel);
		}

		return keyPerformanceIndicatorsMasterModelList;

	}

	/**
	 * method to get drop down data from id of key performance indicator
	 * 
	 * @param id
	 *            of key performance indicator
	 * @return list of all dropdown elements
	 */
	@Override
	public List<DropdownModel> getDropDownData(long id) {
		KeyPerformanceIndicatorsMaster keyPerformanceIndicatorsMaster = new KeyPerformanceIndicatorsMaster();
		keyPerformanceIndicatorsMaster.setId(id);
		List<KeyPerformanceIndicatorsLabels> keyPerformanceIndicatorsLabelsList = keyPerformanceIndicatorsLabelsRepository
				.findByKeyPerformanceIndicatorsMasterId(keyPerformanceIndicatorsMaster);

		List<DropdownModel> dropdownModelsList = new ArrayList<>();

		for (KeyPerformanceIndicatorsLabels dataList : keyPerformanceIndicatorsLabelsList) {
			DropdownModel dropdownModel = new DropdownModel();

			dropdownModel.setId(dataList.getId());
			dropdownModel.setName(dataList.getLabel());

			dropdownModelsList.add(dropdownModel);
		}
		return dropdownModelsList;
	}

	/**
	 * method to get timeline of form according to start date and end date of form
	 * 
	 * @param id
	 *            of user feedback form
	 * @return timeline model list for that form
	 */
	@Override
	public List<DropdownModel> getTimeline(long id) {
		PerformanceFeedbackForm performanceFeedbackForm = userPerformanceFeedbackFormRepository.findById(id)
				.getPerformanceFeedbackFormId();
		Date startDate = performanceFeedbackForm.getUserPerfEvaluationDurationMaster().getStartDate();
		Date endDate = performanceFeedbackForm.getUserPerfEvaluationDurationMaster().getEndDate();

		List<DropdownModel> timelineModelList = getWeeksBetween(startDate, endDate);
		return timelineModelList;
	}

	/**
	 * helper method for data calculating weeks between two given dates
	 * @param startDate 
	 * @param endDate
	 * @return list of timeline model
	 */
	@SuppressWarnings("deprecation")
	private List<DropdownModel> getWeeksBetween(Date startDate, Date endDate) {

		String timelinePeriod = null;
		if (endDate.before(startDate)) {
			return null;
		}
		startDate = resetTime(startDate);
		endDate = resetTime(endDate);

		Calendar cal = new GregorianCalendar();
		cal.setTime(startDate);
		long weeks = 0;
		Format formatter = new SimpleDateFormat("MMM");
		List<DropdownModel> timelineModelList = new ArrayList<DropdownModel>();
		while (cal.getTime().before(endDate)) {
			// add another week
			DropdownModel timelineModel = new DropdownModel();
			timelineModel.setId(weeks);
			weeks++;
			timelinePeriod = "Week " + weeks + ": " + cal.getTime().getDate() + " " + formatter.format(cal.getTime());
			timelineModel.setName(timelinePeriod);
			timelineModelList.add(timelineModel);
			cal.add(Calendar.WEEK_OF_YEAR, 1);
			

		}
		return timelineModelList;
	}

	private static Date resetTime(Date d) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(d);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

}

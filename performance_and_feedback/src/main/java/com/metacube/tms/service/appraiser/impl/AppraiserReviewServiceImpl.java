package com.metacube.tms.service.appraiser.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.tms.entity.EvaluationDurationMaster;
import com.metacube.tms.entity.KeyPerformanceIndicatorsLabels;
import com.metacube.tms.entity.UserPerformanceData;
import com.metacube.tms.entity.UserPerformanceFeedbackForm;
import com.metacube.tms.modal.UserPerformanceDataModel;
import com.metacube.tms.repository.KeyPerformanceGroupMasterRepository;
import com.metacube.tms.repository.appraise.KeyPerformanceIndicatorsLabelsRepository;
import com.metacube.tms.repository.appraise.KeyPerformanceIndicatorsMasterRepository;
import com.metacube.tms.repository.appraise.UserPerformanceDataRepository;
import com.metacube.tms.repository.appraise.UserPerformanceFeedbackFormRepository;
import com.metacube.tms.service.appraiser.AppraiserReviewService;

@Service
public class AppraiserReviewServiceImpl implements AppraiserReviewService {

	@Autowired
	private KeyPerformanceIndicatorsLabelsRepository keyPerformanceIndicatorsLabelsRepository;

	@Autowired
	private KeyPerformanceGroupMasterRepository keyPerformanceGroupMasterRepository;

	@Autowired
	private KeyPerformanceIndicatorsMasterRepository keyPerformanceIndicatorsMasterRepository;

	@Autowired
	private UserPerformanceDataRepository userPerformanceDataRepository;

	@Autowired
	private UserPerformanceFeedbackFormRepository userPerformanceFeedbackFormRepository;

	/*
	 * public List<KeyPerformanceIndicatorsLabels>
	 * getProjectPerformanceIndicatorsLabels() {
	 * 
	 * KeyPerformanceGroupMaster keyPerformanceGroupMaster =
	 * keyPerformanceGroupMasterRepository .findByName("project_performance");
	 * 
	 * KeyPerformanceIndicatorsMaster keyPerformanceIndicatorsMaster =
	 * keyPerformanceIndicatorsMasterRepository
	 * .findAllByKeyPerformanceGroupMasterId(keyPerformanceGroupMaster).get(0);
	 * 
	 * List<KeyPerformanceIndicatorsLabels> keyPerformanceIndicatorsLabelsList =
	 * keyPerformanceIndicatorsLabelsRepository
	 * .findAllByKeyPerformanceIndicatorsMasterId(keyPerformanceIndicatorsMaster);
	 * 
	 * return keyPerformanceIndicatorsLabelsList; }
	 * 
	 * public List<KeyPerformanceIndicatorsMaster>
	 * getOrganisationalDevelopmentLabels() {
	 * 
	 * KeyPerformanceGroupMaster keyPerformanceGroupMaster =
	 * keyPerformanceGroupMasterRepository .findByName("org_development");
	 * 
	 * List<KeyPerformanceIndicatorsMaster> keyPerformanceIndicatorsMasterList =
	 * keyPerformanceIndicatorsMasterRepository
	 * .findAllByKeyPerformanceGroupMasterId(keyPerformanceGroupMaster);
	 * 
	 * return keyPerformanceIndicatorsMasterList; }
	 * 
	 * public List<KeyPerformanceIndicatorsLabels> getSubLabels(long id) {
	 * KeyPerformanceIndicatorsMaster keyPerformanceIndicatorsMaster = new
	 * KeyPerformanceIndicatorsMaster(); keyPerformanceIndicatorsMaster.setId(id);
	 * 
	 * return keyPerformanceIndicatorsLabelsRepository
	 * .findAllByKeyPerformanceIndicatorsMasterId(keyPerformanceIndicatorsMaster); }
	 */

	/*
	 * public List<UserPerformanceDataModel> getPerformanceData(Long id) {
	 * 
	 * List<UserPerformanceDataModel> userPerformanceDataModelList = new
	 * ArrayList<>();
	 * 
	 * userPerformanceDataModelList.addAll(getUserPerformanceDataRecords(id));
	 * userPerformanceDataModelList.addAll(getKeyPerformanceGroupMasterRecords());
	 * 
	 * return userPerformanceDataModelList;
	 * 
	 * }
	 */

	/*
	 * public boolean checkNull(Object data) { if (data == null) { return true; }
	 * return false; }
	 * 
	 * public List<UserPerformanceDataModel> getUserPerformanceDataRecords(Long id)
	 * { UserPerformanceData userPerformanceDataTemporary =
	 * userPerformanceDataRepository.getOne(id);
	 * 
	 * List<UserPerformanceData> userPerformanceDataList =
	 * userPerformanceDataRepository
	 * .findAllByUserUidAndEvaluationDurationMasterIdAndUserPerformanceFeedbackFormId(
	 * userPerformanceDataTemporary.getUserUid(),
	 * userPerformanceDataTemporary.getEvaluationDurationMasterId(),
	 * userPerformanceDataTemporary.getUserPerformanceFeedbackFormId());
	 * 
	 * List<UserPerformanceDataModel> userPerformanceDataModelList = new
	 * ArrayList<UserPerformanceDataModel>();
	 * 
	 * for (UserPerformanceData userPerformanceData : userPerformanceDataList) {
	 * 
	 * UserPerformanceDataModel userPerformanceDataModel = new
	 * UserPerformanceDataModel();
	 * 
	 * if (checkNull(userPerformanceData.getKeyPerformanceIndicatorsLabelsId()
	 * .getKeyPerformanceIndicatorsMasterId().getKeyPerformanceGroupMasterId())) {
	 * continue; }
	 * 
	 * if (!checkNull(userPerformanceData.getKeyPerformanceIndicatorsLabelsId().
	 * getLabel())) { userPerformanceDataModel.setLabel(userPerformanceData.
	 * getKeyPerformanceIndicatorsLabelsId().getLabel()); } if
	 * (!checkNull(userPerformanceData.getKeyPerformanceIndicatorsLabelsId().
	 * getDescription())) { userPerformanceDataModel
	 * .setDescription(userPerformanceData.getKeyPerformanceIndicatorsLabelsId().
	 * getDescription()); } if (!checkNull(userPerformanceData.getTimeSpent())) {
	 * userPerformanceDataModel.setTimeSpent(userPerformanceData.getTimeSpent()); }
	 * if (!checkNull(userPerformanceData.getTimeApproved())) {
	 * userPerformanceDataModel.setTimeApproved(userPerformanceData.getTimeApproved(
	 * )); } if (!checkNull(userPerformanceData.getRating())) {
	 * userPerformanceDataModel.setRating(userPerformanceData.getRating()); } if
	 * (!checkNull(userPerformanceData.getComment1())) {
	 * userPerformanceDataModel.setCommentOne(userPerformanceData.getComment1()); }
	 * if (!checkNull(userPerformanceData.getComment2())) {
	 * userPerformanceDataModel.setCommentTwo(userPerformanceData.getComment2()); }
	 * if (!checkNull(userPerformanceData.getOrder())) {
	 * userPerformanceDataModel.setOrder(userPerformanceData.getOrder()); } if
	 * (!checkNull(userPerformanceData.getKeyPerformanceIndicatorsLabelsId()
	 * .getKeyPerformanceIndicatorsMasterId().getId())) {
	 * userPerformanceDataModel.setKeyPerformanceIndicatorsMasterId(
	 * userPerformanceData
	 * .getKeyPerformanceIndicatorsLabelsId().getKeyPerformanceIndicatorsMasterId().
	 * getId()); } if
	 * (!checkNull(userPerformanceData.getKeyPerformanceIndicatorsLabelsId()
	 * .getKeyPerformanceIndicatorsMasterId().getName())) {
	 * userPerformanceDataModel.setKeyPerformanceIndicatorsMasterName(
	 * userPerformanceData
	 * .getKeyPerformanceIndicatorsLabelsId().getKeyPerformanceIndicatorsMasterId().
	 * getName()); } if
	 * (!checkNull(userPerformanceData.getKeyPerformanceIndicatorsLabelsId().getId()
	 * )) { userPerformanceDataModel.setKeyPerformanceIndicatorsLabelsId(
	 * userPerformanceData.getKeyPerformanceIndicatorsLabelsId().getId()); } if
	 * (!checkNull(userPerformanceData.getKeyPerformanceIndicatorsLabelsId().getName
	 * ())) { userPerformanceDataModel.setKeyPerformanceIndicatorsLabelsName(
	 * userPerformanceData.getKeyPerformanceIndicatorsLabelsId().getName()); }
	 * 
	 * userPerformanceDataModel .setKeyPerformanceGroupMasterId(userPerformanceData.
	 * getKeyPerformanceIndicatorsLabelsId()
	 * .getKeyPerformanceIndicatorsMasterId().getKeyPerformanceGroupMasterId().getId
	 * ()); userPerformanceDataModel
	 * .setKeyPerformanceGroupMasterName(userPerformanceData.
	 * getKeyPerformanceIndicatorsLabelsId()
	 * .getKeyPerformanceIndicatorsMasterId().getKeyPerformanceGroupMasterId().
	 * getName());
	 * 
	 * userPerformanceDataModelList.add(userPerformanceDataModel); } return
	 * userPerformanceDataModelList; }
	 * 
	 * public List<UserPerformanceDataModel> getKeyPerformanceGroupMasterRecords() {
	 * List<UserPerformanceDataModel> userPerformanceDataModelList = new
	 * ArrayList<UserPerformanceDataModel>();
	 * 
	 * List<KeyPerformanceIndicatorsMaster> keyPerformanceIndicatorsMasterList =
	 * keyPerformanceIndicatorsMasterRepository
	 * .findAllByKeyPerformanceGroupMasterIdNotNull();
	 * 
	 * for (KeyPerformanceIndicatorsMaster keyPerformanceIndicatorsMaster :
	 * keyPerformanceIndicatorsMasterList) { UserPerformanceDataModel
	 * userPerformanceDataModel = new UserPerformanceDataModel();
	 * 
	 * if (!checkNull(keyPerformanceIndicatorsMaster.getLabel())) {
	 * userPerformanceDataModel.setLabel(keyPerformanceIndicatorsMaster.getLabel());
	 * } if (!checkNull(keyPerformanceIndicatorsMaster.getDescription())) {
	 * userPerformanceDataModel.setDescription(keyPerformanceIndicatorsMaster.
	 * getDescription()); }
	 * userPerformanceDataModel.setKeyPerformanceIndicatorsMasterId(
	 * keyPerformanceIndicatorsMaster.getId());
	 * userPerformanceDataModel.setKeyPerformanceGroupMasterId(
	 * keyPerformanceIndicatorsMaster.getKeyPerformanceGroupMasterId().getId());
	 * userPerformanceDataModelList.add(userPerformanceDataModel); } return
	 * userPerformanceDataModelList; }
	 */

	public boolean checkNull(Object data) {
		if (data == null) {
			return true;
		}
		return false;
	}

	public List<UserPerformanceDataModel> getPerformanceData(Long userPerformanceFeedbackFormId,
			String keyPerformanceGroupMasterName) {
		if ("project_performance".equals(keyPerformanceGroupMasterName)) {

			List<UserPerformanceDataModel> projectIndicatorDataList = getProjectIndicatorsData(
					userPerformanceFeedbackFormId, keyPerformanceGroupMasterName);
			Collections.sort(projectIndicatorDataList);
			return projectIndicatorDataList;
		} else if ("self_development".equals(keyPerformanceGroupMasterName)) {
			List<UserPerformanceDataModel> selfDevelopmentDataList = getSelfAndOrgDevelopmentData(
					userPerformanceFeedbackFormId, keyPerformanceGroupMasterName);
			Collections.sort(selfDevelopmentDataList);
			return selfDevelopmentDataList;
		} else if ("org_development".equals(keyPerformanceGroupMasterName)) {
			List<UserPerformanceDataModel> organisationalDevelopmentDataList = getSelfAndOrgDevelopmentData(
					userPerformanceFeedbackFormId, keyPerformanceGroupMasterName);
			Collections.sort(organisationalDevelopmentDataList);
			return organisationalDevelopmentDataList;
		}
		return null;
	}

	public List<UserPerformanceDataModel> getProjectIndicatorsData(Long userPerformanceFeedbackFormId,
			String keyPerformanceGroupMasterName) {

		List<KeyPerformanceIndicatorsLabels> keyPerformanceIndicatorsLabelsList = keyPerformanceIndicatorsLabelsRepository
				.findAll();

		List<UserPerformanceDataModel> userPerformanceDataModelList = new ArrayList<>();

		for (KeyPerformanceIndicatorsLabels keyPerformanceIndicatorsLabels : keyPerformanceIndicatorsLabelsList) {
			if (keyPerformanceIndicatorsLabels.getKeyPerformanceIndicatorsMasterId()
					.getKeyPerformanceGroupMasterId() != null
					&& keyPerformanceIndicatorsLabels.getKeyPerformanceIndicatorsMasterId()
							.getKeyPerformanceGroupMasterId().getName().equals(keyPerformanceGroupMasterName)) {

				UserPerformanceDataModel userPerformanceDataModel = new UserPerformanceDataModel();

				if (!checkNull(keyPerformanceIndicatorsLabels.getLabel())) {
					userPerformanceDataModel.setLabel(keyPerformanceIndicatorsLabels.getLabel());
				}
				if (!checkNull(keyPerformanceIndicatorsLabels.getDescription())) {
					userPerformanceDataModel.setDescription(keyPerformanceIndicatorsLabels.getDescription());
				}
				if (!checkNull(keyPerformanceIndicatorsLabels.getOrder())) {
					userPerformanceDataModel.setOrder(keyPerformanceIndicatorsLabels.getOrder());
				}
				if (!checkNull(keyPerformanceIndicatorsLabels.getId())) {
					userPerformanceDataModel
							.setKeyPerformanceIndicatorsLabelsId(keyPerformanceIndicatorsLabels.getId());
				}
				if (!checkNull(keyPerformanceIndicatorsLabels.getName())) {
					userPerformanceDataModel
							.setKeyPerformanceIndicatorsLabelsName(keyPerformanceIndicatorsLabels.getName());
				}
				userPerformanceDataModelList.add(userPerformanceDataModel);
			}
		}
		UserPerformanceFeedbackForm userPerformanceFeedbackForm = new UserPerformanceFeedbackForm();
		userPerformanceFeedbackForm.setId(userPerformanceFeedbackFormId);

		for (UserPerformanceDataModel userPerformanceDataModel : userPerformanceDataModelList) {

			KeyPerformanceIndicatorsLabels keyPerformanceIndicatorsLabels = new KeyPerformanceIndicatorsLabels();
			keyPerformanceIndicatorsLabels.setId(userPerformanceDataModel.getKeyPerformanceIndicatorsLabelsId());

			UserPerformanceData userPerformanceData = userPerformanceDataRepository
					.findByUserPerformanceFeedbackFormIdAndKeyPerformanceIndicatorsLabelsId(userPerformanceFeedbackForm,
							keyPerformanceIndicatorsLabels);
			if (!checkNull(userPerformanceData)) {
				String rating = userPerformanceData.getRating();
				userPerformanceDataModel.setRating(rating);
				if (!checkNull(userPerformanceData.getComment1())) {
					userPerformanceDataModel.setCommentOne(userPerformanceData.getComment1());
				}
				if (!checkNull(userPerformanceData.getId())) {
					userPerformanceDataModel.setUserPerformanceDataId(userPerformanceData.getId());
				}
				if (!checkNull(userPerformanceData.getUid())) {
					userPerformanceDataModel.setUid(userPerformanceData.getUid());
				}
			}
		}

		return userPerformanceDataModelList;

	}

	public List<UserPerformanceDataModel> getSelfAndOrgDevelopmentData(Long userPerformanceFeedbackFormId,
			String keyPerformanceGroupMasterName) {

		List<KeyPerformanceIndicatorsLabels> keyPerformanceIndicatorsLabelsList = keyPerformanceIndicatorsLabelsRepository
				.findAll();

		List<UserPerformanceDataModel> userPerformanceDataModelList = new ArrayList<>();

		for (KeyPerformanceIndicatorsLabels keyPerformanceIndicatorsLabels : keyPerformanceIndicatorsLabelsList) {

			if (keyPerformanceIndicatorsLabels.getKeyPerformanceIndicatorsMasterId()
					.getKeyPerformanceGroupMasterId() != null
					&& keyPerformanceIndicatorsLabels.getKeyPerformanceIndicatorsMasterId()
							.getKeyPerformanceGroupMasterId().getName().equals(keyPerformanceGroupMasterName)) {

				UserPerformanceDataModel userPerformanceDataModel = new UserPerformanceDataModel();

				if (!checkNull(keyPerformanceIndicatorsLabels.getLabel())) {
					userPerformanceDataModel.setLabel(keyPerformanceIndicatorsLabels.getLabel());
				}
				if (!checkNull(keyPerformanceIndicatorsLabels.getDescription())) {
					userPerformanceDataModel.setDescription(keyPerformanceIndicatorsLabels.getDescription());
				}
				if (!checkNull(keyPerformanceIndicatorsLabels.getOrder())) {
					userPerformanceDataModel.setOrder(keyPerformanceIndicatorsLabels.getOrder());
				}
				if (!checkNull(keyPerformanceIndicatorsLabels.isEditable())) {
					userPerformanceDataModel.setEditable(keyPerformanceIndicatorsLabels.isEditable());
				}
				if (!checkNull(keyPerformanceIndicatorsLabels.getId())) {
					userPerformanceDataModel
							.setKeyPerformanceIndicatorsLabelsId(keyPerformanceIndicatorsLabels.getId());
				}
				if (!checkNull(keyPerformanceIndicatorsLabels.getName())) {
					userPerformanceDataModel
							.setKeyPerformanceIndicatorsLabelsName(keyPerformanceIndicatorsLabels.getName());
				}
				if (!checkNull(keyPerformanceIndicatorsLabels.getKeyPerformanceIndicatorsMasterId().getId())) {
					userPerformanceDataModel.setKeyPerformanceIndicatorsMasterId(
							keyPerformanceIndicatorsLabels.getKeyPerformanceIndicatorsMasterId().getId());
				}
				if (!checkNull(keyPerformanceIndicatorsLabels.getKeyPerformanceIndicatorsMasterId().getName())) {
					userPerformanceDataModel.setKeyPerformanceIndicatorsMasterName(
							keyPerformanceIndicatorsLabels.getKeyPerformanceIndicatorsMasterId().getName());
				}
				userPerformanceDataModelList.add(userPerformanceDataModel);
			}
		}

		UserPerformanceFeedbackForm userPerformanceFeedbackForm = new UserPerformanceFeedbackForm();
		userPerformanceFeedbackForm.setId(userPerformanceFeedbackFormId);

		for (UserPerformanceDataModel userPerformanceDataModel : userPerformanceDataModelList) {

			KeyPerformanceIndicatorsLabels keyPerformanceIndicatorsLabels = new KeyPerformanceIndicatorsLabels();
			keyPerformanceIndicatorsLabels.setId(userPerformanceDataModel.getKeyPerformanceIndicatorsLabelsId());

			UserPerformanceData userPerformanceData = userPerformanceDataRepository
					.findByUserPerformanceFeedbackFormIdAndKeyPerformanceIndicatorsLabelsId(userPerformanceFeedbackForm,
							keyPerformanceIndicatorsLabels);

			if (!checkNull(userPerformanceData)) {
				if (!checkNull(userPerformanceData.getComment1())) {
					userPerformanceDataModel.setCommentOne(userPerformanceData.getComment1());
				}
				if (!checkNull(userPerformanceData.getComment2())) {
					userPerformanceDataModel.setCommentTwo(userPerformanceData.getComment2());
				}
				if (!checkNull(userPerformanceData.getId())) {
					userPerformanceDataModel.setUserPerformanceDataId(userPerformanceData.getId());
				}
				if (!checkNull(userPerformanceData.getUid())) {
					userPerformanceDataModel.setUid(userPerformanceData.getUid());
				}
				if (userPerformanceDataModel.isEditable()) {

					if (!checkNull(userPerformanceData.getTimeSpent())) {
						userPerformanceDataModel.setTimeSpent(userPerformanceData.getTimeSpent());
					}
					if (!checkNull(userPerformanceData.getTimeApproved())) {
						userPerformanceDataModel.setTimeSpent(userPerformanceData.getTimeApproved());
					}

				} else {
					if (!checkNull(userPerformanceData.getRating())) {
						userPerformanceDataModel.setRating(userPerformanceData.getRating());
					}
				}
			} else {
				if (userPerformanceDataModel.isEditable()) {
					userPerformanceDataModel.setTimeSpent(0);
				}

			}
		}
		return userPerformanceDataModelList;
	}

	public List<UserPerformanceData> saveReview(Long userPerformanceFeedbackFormId,
			List<UserPerformanceDataModel> userPerformanceDataModelList) {

		UserPerformanceFeedbackForm userPerformanceFeedbackForm = userPerformanceFeedbackFormRepository
				.getOne(userPerformanceFeedbackFormId);

		List<UserPerformanceData> userPerformanceDataList = new ArrayList<>();

		if (!checkNull(userPerformanceFeedbackForm)) {

			for (UserPerformanceDataModel userPerformanceDataModel : userPerformanceDataModelList) {

				if (!checkNull(userPerformanceDataModel.getRating())
						|| !checkNull(userPerformanceDataModel.getTimeApproved())) {

					UserPerformanceData userPerformanceData = new UserPerformanceData();

					if (!checkNull(userPerformanceDataModel.getUid())) {
						userPerformanceData.setUid(userPerformanceDataModel.getUid());
					}

					if (!checkNull(userPerformanceDataModel.getUserPerformanceDataId())) {
						userPerformanceData.setId(userPerformanceDataModel.getUserPerformanceDataId());
					}
					if (!checkNull(userPerformanceFeedbackForm.getUserUid())) {
						userPerformanceData.setUserUid(userPerformanceFeedbackForm.getUserUid());
					}
					if (!checkNull(userPerformanceFeedbackForm.getOrgId())) {
						userPerformanceData.setOrgId(userPerformanceFeedbackForm.getOrgId());
					}

					userPerformanceData.setUserPerformanceFeedbackFormId(userPerformanceFeedbackForm);
					userPerformanceData.setOrder(1);
					userPerformanceData.setTimeSpent(1);

					EvaluationDurationMaster evaluationDurationMasterId = userPerformanceFeedbackForm
							.getPerformanceFeedbackFormId().getUserPerfEvaluationDurationMaster();
					if (!checkNull(evaluationDurationMasterId)) {
						userPerformanceData.setEvaluationDurationMasterId(evaluationDurationMasterId);
					}

					if (!checkNull(userPerformanceDataModel.getKeyPerformanceIndicatorsLabelsId())) {
						KeyPerformanceIndicatorsLabels keyPerformanceIndicatorsLabels = new KeyPerformanceIndicatorsLabels();
						keyPerformanceIndicatorsLabels
								.setId(userPerformanceDataModel.getKeyPerformanceIndicatorsLabelsId());
						userPerformanceData.setKeyPerformanceIndicatorsLabelsId(keyPerformanceIndicatorsLabels);
					}

					if (!checkNull(userPerformanceDataModel.getCommentOne())) {
						userPerformanceData.setComment1(userPerformanceDataModel.getCommentOne());
					}
					if (!checkNull(userPerformanceDataModel.getCommentTwo())) {
						userPerformanceData.setComment2(userPerformanceDataModel.getCommentTwo());
					}

					if (!checkNull(userPerformanceDataModel.getRating())) {
						userPerformanceData.setRating(userPerformanceDataModel.getRating());
					}
					if (!checkNull(userPerformanceDataModel.getTimeApproved())) {
						userPerformanceData.setTimeApproved(userPerformanceDataModel.getTimeApproved());
					}
					userPerformanceDataList.add(userPerformanceData);
				}
			}
		}
		return userPerformanceDataRepository.saveAll(userPerformanceDataList);
	}
}

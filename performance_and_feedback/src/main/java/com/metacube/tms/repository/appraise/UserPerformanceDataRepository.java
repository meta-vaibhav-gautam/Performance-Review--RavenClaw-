package com.metacube.tms.repository.appraise;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.tms.entity.KeyPerformanceIndicatorsLabels;
import com.metacube.tms.entity.UserPerformanceData;
import com.metacube.tms.entity.UserPerformanceFeedbackForm;

@Repository
public interface UserPerformanceDataRepository extends JpaRepository<UserPerformanceData,Long>{
	
	List<UserPerformanceData> findByUserPerformanceFeedbackFormId(UserPerformanceFeedbackForm userPerformanceFeedbackFormId);

	/**
	 * finds all records by userUid
	 * @param userUid
	 * @return
	 */
	public List<UserPerformanceData> findAllByUserUid(Long userUid);

	/**
	 * finds record by userPerformanceFeedbackFormId and keyPerformanceIndicatorsLabelsId
	 * @param userPerformanceFeedbackFormId
	 * @param keyPerformanceIndicatorsLabelsId
	 * @return
	 */
	public UserPerformanceData findByUserPerformanceFeedbackFormIdAndKeyPerformanceIndicatorsLabelsId(
			UserPerformanceFeedbackForm userPerformanceFeedbackFormId,
			KeyPerformanceIndicatorsLabels keyPerformanceIndicatorsLabelsId);

}

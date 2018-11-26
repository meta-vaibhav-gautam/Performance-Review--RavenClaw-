package com.metacube.tms.repository.appraise;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.tms.entity.KeyPerformanceIndicatorsLabels;
import com.metacube.tms.entity.KeyPerformanceIndicatorsMaster;

/**
 * 
 * Repository for getting data from key performance indicator labels
 *
 */
@Repository
public interface KeyPerformanceIndicatorsLabelsRepository extends JpaRepository<KeyPerformanceIndicatorsLabels, Long> {

	List<KeyPerformanceIndicatorsLabels> findByKeyPerformanceIndicatorsMasterId(KeyPerformanceIndicatorsMaster keyPerformanceIndicatorsMasterId);
}

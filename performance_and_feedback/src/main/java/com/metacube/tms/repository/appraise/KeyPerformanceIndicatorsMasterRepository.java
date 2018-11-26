package com.metacube.tms.repository.appraise;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.tms.entity.KeyPerformanceIndicatorsMaster;
/**
 * 
 * Repository for getting data from key performance indicator master table
 *
 */
@Repository
public interface KeyPerformanceIndicatorsMasterRepository extends JpaRepository<KeyPerformanceIndicatorsMaster, Long>{
	List<KeyPerformanceIndicatorsMaster> findAll();
}

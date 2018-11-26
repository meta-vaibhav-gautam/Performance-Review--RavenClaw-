package com.metacube.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.tms.entity.EvaluationDurationMaster;
import com.metacube.tms.entity.UserPerformanceFeedbackForm;

@Repository
public interface EvaluationDurationMasterRepository extends JpaRepository<UserPerformanceFeedbackForm, Long>{
}

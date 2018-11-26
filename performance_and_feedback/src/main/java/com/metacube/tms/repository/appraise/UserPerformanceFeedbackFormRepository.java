package com.metacube.tms.repository.appraise;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.tms.entity.PerformanceFeedbackForm;
import com.metacube.tms.entity.UserPerformanceFeedbackForm;

/**
 * 
 * Class for getting data from user performance feedback form table.
 *
 * @param <E>
 */
@Repository
public interface UserPerformanceFeedbackFormRepository extends JpaRepository<UserPerformanceFeedbackForm, Long> {
	List<UserPerformanceFeedbackForm> findByuserUid(long userId);

	UserPerformanceFeedbackForm findById(long id);
}

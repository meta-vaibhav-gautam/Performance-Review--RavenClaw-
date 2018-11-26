/**
 * 
 */
package com.metacube.tms.repository.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.tms.entity.PerformanceFeedbackForm;

/**
 * @author Jai Kumar Garg
 *
 */
@Repository
public interface PerformanceFeedbackFormRepository
		extends JpaRepository<PerformanceFeedbackForm, Long> {
}

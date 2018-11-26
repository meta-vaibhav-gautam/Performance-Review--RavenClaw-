/**
 * 
 */
package com.metacube.tms.service.admin.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.tms.entity.PerformanceFeedbackForm;
import com.metacube.tms.repository.admin.PerformanceFeedbackFormRepository;
import com.metacube.tms.service.admin.PerformanceFeedbackFormService;
import com.metacube.tms.service.impl.BaseServiceImpl;

/**
 * @author Jai Kumar Garg
 *
 */
@Service
public class PerformanceFeedbackFormImpl extends BaseServiceImpl
		implements PerformanceFeedbackFormService {

	@Autowired
	PerformanceFeedbackFormRepository performanceFeedbackFormRepository;
	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.metacube.tms.service.admin.PerformanceFeedbackFormService#getAllForms()
	 */
	@Override
	public Iterable<PerformanceFeedbackForm> getAllForms(Long orgId) {
		// TODO Auto-generated method stub
		Filter filter = (Filter) entityManager.unwrap(Session.class).enableFilter("filterByOrgId");
		entityManager.unwrap(Session.class).enableFilter("activeFilter");
		filter.setParameter("org_id", orgId);
		Iterable<PerformanceFeedbackForm> iterable = performanceFeedbackFormRepository.findAll();
        entityManager.unwrap(Session.class).disableFilter("filterByEmail");
		return iterable;
	}

}

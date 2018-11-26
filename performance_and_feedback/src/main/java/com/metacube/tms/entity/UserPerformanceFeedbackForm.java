package com.metacube.tms.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.metacube.tms.entity.enums.UserPerformanceFeedbackFormStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_performance_feedback_form")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserPerformanceFeedbackForm extends BaseEntity{
	
	@Column(name = "uid", unique = true, nullable = false)
	private UUID uid;
	
	@Column(name = "user_uid", nullable = false)
	private Long userUid;
	
	@Column(name = "org_id", nullable = false)
	private Long orgId;
	
	@Column(name = "manager_uid")
	private Long managerUid;
	
	@Column(name = "normalizer_uid")
	private Long normalizerUid;
	
	@OneToOne
	@JoinColumn(name = "performance_feedback_form_id", nullable = false)
	private PerformanceFeedbackForm performanceFeedbackFormId;
	
	@Column(name = "email_notified", columnDefinition = "boolean default false", 
			nullable = false)
	private boolean emailNotified;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status", nullable = false)
	private UserPerformanceFeedbackFormStatus status;
	
	@PrePersist
	public void prePersist() {
	uid = UUID.randomUUID();
	}
}

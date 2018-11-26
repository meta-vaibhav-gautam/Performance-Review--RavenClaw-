package com.metacube.tms.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.springframework.format.annotation.DateTimeFormat;
import com.metacube.tms.entity.enums.PerformanceFeedbackFormStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "performance_feedback_form")
@FilterDef(name = "filterByOrgId" , parameters = {
		@ParamDef(name = "org_id", type = "long") })
@Filter(name = "filterByOrgId", condition = ":org_id = org_id")
//@FilterDef(name = "activeFilter")
//@Filter(name = "activeFilter", condition = "true = is_active")
public class PerformanceFeedbackForm extends BaseEntity {

	@Column(name = "uid", unique = true, nullable = false)
	private UUID uid;

	@Column(name = "org_id", nullable = false)
	private Long orgId;

	@Column(name = "year", nullable = false)
	private Integer year;

	@ManyToOne
	@JoinColumn(name = "user_perf_evaluation_duration_master_id")
	private EvaluationDurationMaster userPerfEvaluationDurationMaster;

	@ManyToOne
	@JoinColumn(name = "form_template_id", nullable = false)
	private FormTemplate formTemplate;

	@Column(name = "lock_date", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date lockDate;

	@Column(name = "publish_date", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date publishDate;

	@Column(name = "comments")
	private String comments;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status", nullable = false)
	private PerformanceFeedbackFormStatus status;
	
	@PrePersist
	public void prePersist() {
	uid = UUID.randomUUID();
	}
}

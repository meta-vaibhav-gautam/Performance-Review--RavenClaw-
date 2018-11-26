package com.metacube.tms.entity;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_performance_data")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserPerformanceData extends BaseEntity {

	@Column(name = "uid", unique = true, nullable = false)
	private UUID uid;

	@Column(name = "user_uid", nullable = false)
	private Long userUid;

	@Column(name = "org_id", nullable = false)
	private Long orgId;

	@ManyToOne
	@JoinColumn(name = "user_performance_feedback_form_id", nullable = false)
	private UserPerformanceFeedbackForm userPerformanceFeedbackFormId;

	@Column(name = "\"order\"", nullable = false)
	private Integer order;

	@ManyToOne
	@JoinColumn(name = "evaluation_duration_master_id", nullable = false)
	private EvaluationDurationMaster evaluationDurationMasterId;

	@ManyToOne
	@JoinColumn(name = "key_performance_indicators_labels_id", nullable = false)
	private KeyPerformanceIndicatorsLabels keyPerformanceIndicatorsLabelsId;

	@Column(name = "time_spent", nullable = false)
	private Integer timeSpent;

	@Column(name = "time_approved")
	private Integer timeApproved;

	@Column(name = "comment1")
	private String comment1;

	@Column(name = "comment2")
	private String comment2;

	@Column(name = "rating")
	private String rating;
	
	@Column(name = "timeline_index")
	private String timelineIndex;
	
	@PrePersist
	public void prePersist() {
	uid = UUID.randomUUID();
	}
}

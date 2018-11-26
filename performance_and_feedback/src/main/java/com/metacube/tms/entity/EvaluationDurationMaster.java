package com.metacube.tms.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.metacube.tms.entity.enums.EvaluationDurationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "evaluation_duration_master")
public class EvaluationDurationMaster extends BaseEntity{
	
	@Column(name = "uid", unique = true, nullable = false)
	private UUID uid;
	
	@Column(name = "org_id", nullable = false)
	private Long orgId;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "evaluation_duration")
	private EvaluationDurationType evaluationDuration;
	
	@PrePersist
	public void prePersist() {
	uid = UUID.randomUUID();
	}
}
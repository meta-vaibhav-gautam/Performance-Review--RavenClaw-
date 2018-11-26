package com.metacube.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "key_performance_group_master")
public class KeyPerformanceGroupMaster extends BaseEntity {
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "label", nullable = false)
	private String label;
	
	@Column(name = "weightage")
	private Double weightage;
	
	@Column(name = "org_id", nullable = false)
	private Long orgId;
}

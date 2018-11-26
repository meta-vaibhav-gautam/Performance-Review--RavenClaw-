package com.metacube.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "key_performance_indicators_master")
public class KeyPerformanceIndicatorsMaster extends BaseEntity{
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "label", nullable = false)
    private String label;
    
    @Column(name = "description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "key_performance_group_master_id")
    private KeyPerformanceGroupMaster keyPerformanceGroupMasterId;
    
    @Column(name = "org_id", nullable = false)
	private Long orgId;
    
    @Column(name = "supporting_header_text")
    private String supportingHeaderText;
}

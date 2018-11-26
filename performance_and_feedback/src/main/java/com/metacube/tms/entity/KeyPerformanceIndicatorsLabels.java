package com.metacube.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.metacube.tms.modal.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "key_performance_indicators_labels")
public class KeyPerformanceIndicatorsLabels extends BaseEntity{
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "label", nullable = false)
    private String label;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "\"order\"")
    private Integer order;
    
    @Column(name = "is_editable", nullable = false)
    private boolean isEditable;
    
    @ManyToOne
    @JoinColumn(name = "key_performance_indicators_master_id", nullable = false)
    private KeyPerformanceIndicatorsMaster keyPerformanceIndicatorsMasterId;
}

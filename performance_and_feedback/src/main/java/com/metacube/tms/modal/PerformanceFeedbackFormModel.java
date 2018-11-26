package com.metacube.tms.modal;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.metacube.tms.entity.enums.PerformanceFeedbackFormStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceFeedbackFormModel extends BaseModel
		implements Serializable {
	private UUID uid;
	private Long orgId;
	private Integer year;
	private EvaluationDurationMasterModel userPerfEvaluationDurationMaster;
	private FormTemplateModel formTemplate;
	private Date lockDate;
	private Date publishDate;
	private String comments;
	private PerformanceFeedbackFormStatus status;
	private Integer totalEmployees;
}

package com.metacube.tms.modal;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.metacube.tms.entity.enums.EvaluationDurationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDurationMasterModel extends BaseModel
		implements Serializable {

	private UUID uid;
	private Long orgId;
	private String title;
	private Date startDate;
	private Date endDate;
	private EvaluationDurationType evaluationDuration;

}

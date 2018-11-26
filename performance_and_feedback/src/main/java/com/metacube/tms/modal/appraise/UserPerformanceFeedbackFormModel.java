package com.metacube.tms.modal.appraise;

import com.metacube.tms.modal.BaseModel;
import com.metacube.tms.modal.EmployeeModal;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Class for representing dashboard data of appraise.
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class for representing dashboard data of appraise.")
public class UserPerformanceFeedbackFormModel extends BaseModel {

	private int year;

	private String quarter;

	private String status;

	private String managerName;

	private String normaliserName;

	private String publishDate;

	private String lastUpdatedDate;
}

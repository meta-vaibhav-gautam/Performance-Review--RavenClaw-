package com.metacube.tms.modal;

import java.util.Date;

import com.metacube.tms.entity.enums.PerformanceFeedbackFormStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamPerformanceModal {
	private Long userUid;
	private Date doj;
	private String email;
	private String name;
	private String project;
	private String empId;
	private int year;
	private String title;
	private PerformanceFeedbackFormStatus status;
	private Date lastModifiedDate;
	private Long evaluationDurationMasterId;
	private Long userPerformanceFeedbackFormId;
}

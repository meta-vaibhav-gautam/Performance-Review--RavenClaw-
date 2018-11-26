package com.metacube.tms.modal.appraise;

import com.metacube.tms.modal.BaseModel;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class representing data of key performance indicators master table")
public class KeyPerformanceIndicatorsMasterModel extends BaseModel {
	String name;
	String label;
	String description;
}

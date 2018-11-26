package com.metacube.tms.modal.appraise;

import com.metacube.tms.modal.BaseModel;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Class for Appraise Data Manipulation")
public class AppraiseDataModel extends BaseModel{
	private DropdownModel dropDown;
	private String timeline;
	private int timeSpent;
	private String comment1;
	private String comment2;
}

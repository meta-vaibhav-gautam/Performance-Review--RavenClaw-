package com.metacube.tms.modal.appraise;

import com.metacube.tms.modal.BaseModel;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class representing dropdownws")
public class DropdownModel extends BaseModel {
	String name;
}

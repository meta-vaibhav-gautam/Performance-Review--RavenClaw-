package com.metacube.tms.modal.appraise;

import java.util.List;

import com.metacube.tms.modal.BaseModel;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Class for Appraise Data Key Indication")
public class AppraiseDataKeyIndicatorModel extends BaseModel {

	private List<AppraiseDataModel> appraiseDataModelList;
}

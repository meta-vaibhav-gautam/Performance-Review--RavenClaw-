package com.metacube.tms.modal;

import java.util.UUID;

import com.metacube.tms.modal.enums.Rating;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPerformanceDataModel extends BaseModel implements Comparable<UserPerformanceDataModel> {
	UUID uid;
	String label;
	String description;
	Integer timeSpent;
	Integer timeApproved;
	Rating rating;
	String commentOne;
	String commentTwo;
	Integer order;
	Long keyPerformanceGroupMasterId;
	String keyPerformanceGroupMasterName;
	Long keyPerformanceIndicatorsMasterId;
	String keyPerformanceIndicatorsMasterName;
	Long keyPerformanceIndicatorsLabelsId;
	String keyPerformanceIndicatorsLabelsName;
	Long userPerformanceDataId;
	boolean isEditable;

	@Override
	public int compareTo(UserPerformanceDataModel userPerformanceDataModel) {
		// TODO Auto-generated method stub
		return this.order - userPerformanceDataModel.order;
	}

}

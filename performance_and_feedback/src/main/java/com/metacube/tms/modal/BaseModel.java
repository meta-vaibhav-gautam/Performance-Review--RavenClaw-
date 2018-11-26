package com.metacube.tms.modal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {

	private Long id;
	private boolean isActive;

}

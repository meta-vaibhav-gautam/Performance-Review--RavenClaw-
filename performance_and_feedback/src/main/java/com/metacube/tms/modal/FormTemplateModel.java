package com.metacube.tms.modal;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormTemplateModel extends BaseModel implements Serializable {
	private String name;
}

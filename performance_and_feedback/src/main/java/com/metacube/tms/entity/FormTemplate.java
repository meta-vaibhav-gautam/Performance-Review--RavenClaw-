package com.metacube.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "form_template")
public class FormTemplate extends BaseEntity{
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
}

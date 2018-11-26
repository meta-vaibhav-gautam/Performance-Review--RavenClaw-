package com.metacube.tms.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;

import com.metacube.tms.config.Auditable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anurag Kumawat<anurag.kumawat@metacube.com>
 * @since 03-Nov-2018
 */

@MappedSuperclass
@Getter
@Setter
@FilterDef(name = "activeFilter")
@Filter(name = "activeFilter", condition = "true = is_active")
public class BaseEntity extends Auditable<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id; // will be set when persisting

	private boolean isActive = true;

}


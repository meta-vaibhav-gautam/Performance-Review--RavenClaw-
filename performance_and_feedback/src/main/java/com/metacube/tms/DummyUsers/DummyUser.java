package com.metacube.tms.DummyUsers;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor	
public class DummyUser {
	private Long userId;
	private String name;
	private String empId;
	private String project;
	private String email;
	private Date doj;
	
}

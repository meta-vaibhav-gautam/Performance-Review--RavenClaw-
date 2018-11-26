package com.metacube.tms.DummyUsers;

import java.sql.Date;

public class DummyUserFactory {
	public DummyUser[] dummyUserData = new DummyUser[2];

	public DummyUserFactory() {
		// dummyUserData[0] = new DummyUser((long) 1,"Amit Agarwal","E15/1030","ECi");
		// dummyUserData[1] = new DummyUser((long) 2,"Khushboo
		// Saxena","E14/1120","ECi");
		// dummyUserData[2] = new DummyUser((long) 3,"Rahul Sharma","E16/1243","LND");
		dummyUserData[0] = new DummyUser((long) 4, "Akshit Bhandari", "E15/1056", "ECi", "akshit.bhandari@metacube.com",
				Date.valueOf("2018-10-20"));
		dummyUserData[1] = new DummyUser((long) 5, "Mohit Sharma", "E14/1650", "PNF", "mohit.sharma@metacube.com",
				Date.valueOf("2018-10-20"));
	}
}

package com.revature.controller;

import org.hibernate.Session;

import com.revature.service.FakeService;
import com.revature.utils.SessionUtility;

public class FakeController {

	private static FakeService fakeService = new FakeService();
	
	public static void main(String[] args) {
		Session currentSession = SessionUtility.getSessionFactory().getCurrentSession(); // This will open a new session
		// Which I am ultimately hoping, will be tracked whenever I decide to call
		
		System.out.println(fakeService.testSessionEquals(currentSession));
		
	}
	
}

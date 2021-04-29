package com.revature.service;

import org.hibernate.Session;

import com.revature.utils.SessionUtility;

public class FakeService {

	public boolean testSessionEquals(Session session) {
		//System.out.println(Thread.currentThread().getName());
		return session == SessionUtility.getSessionFactory().getCurrentSession();
	}
	
}

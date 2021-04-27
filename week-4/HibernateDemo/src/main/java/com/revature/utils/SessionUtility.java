package com.revature.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtility {
	
	// This is a singleton SessionFactory, which means only a single instance during the running of our application
	private static SessionFactory sessionFactory;
	
	public synchronized static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration()
								.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"))
								.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"))
								.configure("hibernate.cfg.xml")
								.buildSessionFactory();
		}
		
		return sessionFactory;
	}
	
}

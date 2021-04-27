package com.revature.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Ship;
import com.revature.utils.SessionUtility;

public class CachingDemo {

	public static void main(String[] args) {
		/*
		 * Session 1
		 */
		Session session = SessionUtility.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();
		
		session.find(Ship.class, 1);
		session.find(Ship.class, 1);
		session.find(Ship.class, 1);
		session.find(Ship.class, 1);
		session.find(Ship.class, 1);
		session.find(Ship.class, 1);
		session.find(Ship.class, 1);
		session.find(Ship.class, 1);
		
//		Ship ship = session.find(Ship.class, 1);
		
		// Lazy loading the pirate when we need it here
//		System.out.println(ship.getPirates());
		
		// Even though I used find many different times, Hibernate only sends a single select to the database
		// This is an example of L1 caching in action
		
		tx.commit();
		
		session.close();
		
		
		/*
		 * Session 2
		 */
		session = SessionUtility.getSessionFactory().openSession();

		tx = session.beginTransaction();
		
		session.find(Ship.class, 1);
		session.find(Ship.class, 1);
		session.find(Ship.class, 1);
		session.find(Ship.class, 1);
		session.find(Ship.class, 1);
		session.find(Ship.class, 1);
		session.find(Ship.class, 1);
		session.find(Ship.class, 1);
		session.find(Ship.class, 1);
		
		// Even though I used find many different times, Hibernate only sends a single select to the database
		// This is an example of L1 caching in action
		
		tx.commit();
		
		session.close();
	}

}

package com.revature.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Ship;
import com.revature.utils.SessionUtility;

public class ProxyObjectExample {

	public static void main(String[] args) {
		Session session = SessionUtility.getSessionFactory().openSession();
		// Load gives us a proxy object, which stands in place of some real data. It only retrieves data when necessary
		// through the getters
		
		// Proxy objects ARE persistent
		Ship proxyShip = session.load(Ship.class, 1); // You will notice that a select statement is not sent to the database
		// when we get this proxyShip w/ id of 1.
		
		// But, when we call a getter,
		// It will actually then contact the database for some data
		// Before this happens, the proxyShip object is totally empty
		System.out.println(proxyShip.getShipName());
		
		Transaction tx = session.beginTransaction();
		proxyShip.setShipName("Green Pearl");
		tx.commit();
	}

}

package com.revature.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Pirate;
import com.revature.models.Ship;
import com.revature.utils.SessionUtility;

public class TestBidirectionalRelationship {

	public static void main(String[] args) {
		Session session = SessionUtility.getSessionFactory().openSession();
		
		Ship ship1 = session.find(Ship.class, 1);

//		System.out.println(ship1);
//		
		Transaction tx = session.beginTransaction();
//		
//		ship1.addPirate(new Pirate("Bluebeard", "Pegleg"));
//		
//		session.merge(ship1);
		
		Pirate pirate = new Pirate("Yellowbeard", "Pegleg");
		
		pirate.setShip(ship1);
		
		session.persist(pirate);
		
		// When we run commit, it is also flushing beforehand
		// by flush, it is basically meaning 'send the appropriate SQL commands to the database'
		// And then it will actually commit the transaction
		tx.commit();
	}

}

package com.revature.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Pirate;
import com.revature.models.Ship;
import com.revature.models.ShipDetail;
import com.revature.utils.SessionUtility;

public class Test {

	public static void main(String[] args) {
		Session session = SessionUtility.getSessionFactory().openSession();

//		Ship ship = session.get(Ship.class, 1); // When we use .get, our ship object is in the persistent state
//		System.out.println(ship);
//		
//		Transaction tx = session.beginTransaction();
//		
//		Pirate pirate = new Pirate(0, null, "Edward", "Thatch");
//		
//		session.save(pirate);
//		
//		pirate.setShip(ship); // I can actually set my pirate to this particular ship
//		
//		tx.commit();
//		
//		Pirate p2 = session.get(Pirate.class, 1);
//		System.out.println(p2);
		
		// This is HQL
//		Pirate edward = (Pirate) session.createQuery("FROM Pirate p WHERE p.firstName = 'Edward'").getSingleResult();
//		
//		// getting all pirates
//		// This is also HQL
//		List<Pirate> pirates = session.createQuery("FROM Pirate p").getResultList();
//		System.out.println(pirates);
//		
//		// Getting pirates that belong to ship w/ id 1
		// This is also HQL
		List<Pirate> piratesOfShipId1 = session.createQuery("SELECT p FROM Pirate p JOIN p.ship s WHERE s.id = 1").getResultList();
		System.out.println("pirates of ship id 1: " + piratesOfShipId1);
//		
////		System.out.println(edward);
//		System.out.println(edward.getShip());
		
		// With Hibernate, we still follow the 3 layered architecture of the Controller layer, service layer,
		// and dao layer. 
		
		// Hibernate operations will occur over on the dao layer.
		
		// So, for project-1, use Hibernate, because it will make things a lot easier
		// Just get past the initial setup of Hibernate and the mapping of Entities
		
		/*
		 * 
		 */
		
		Ship ship1 = session.find(Ship.class, 1);
		// What hibernate object state is ship1 in?
		// Persistent, because when you retrieve a new object from the database through hibernate, you will be given a persistent object.
		
		Transaction tx1 = session.beginTransaction();
		
		ShipDetail sd = new ShipDetail(100, "a ship"); // This is a transient object, because it is not associated w/ hibernate
		
		// session.persist(sd); // By saving the object, we make it persistent (meaning an entry in the DB will also be created)
		// and then we will not have the issue with 'TransientObjectException: 
		// object references an unsaved transient instance - save the transient instance before flushing: com.revature.models.ShipDetail'
		
		// Instead of having to persist the ShipDetail, then setting the shipDetail of our ship to that object, we can instead
		// do both operations from ship1, by having a cascade type set for our relation
		
//		ship1.setShipName("Black Pearl"); // we can change the ship name, and once we commit, the value will be changed on the database
		ship1.setShipDetail(sd);
		session.merge(ship1);
		
		tx1.commit(); // When you have a persistent object, such as ship1, when we
		// commit a transaction or use session.flush(), it synchronize what was done here with the database, and vice versa
	}

}

package com.revature.main;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Pirate;
import com.revature.utils.SessionUtility;

public class Test {

	public static void main(String[] args) {
		Session session = SessionUtility.getSession();

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
		Pirate edward = (Pirate) session.createQuery("FROM Pirate p WHERE p.firstName = 'Edward'").getSingleResult();
		
		// getting all pirates
		// This is also HQL
		List<Pirate> pirates = session.createQuery("FROM Pirate p").getResultList();
		System.out.println(pirates);
		
		// Getting pirates that belong to ship w/ id 1
		// This is also HQL
		List<Pirate> piratesOfShipId1 = session.createQuery("SELECT p FROM Pirate p JOIN p.ship s WHERE s.id = 1").getResultList();
		System.out.println("pirates of ship id 1: " + piratesOfShipId1);
		
//		System.out.println(edward);
		System.out.println(edward.getShip());
		
		// With Hibernate, we still follow the 3 layered architecture of the Controller layer, service layer,
		// and dao layer. 
		
		// Hibernate operations will occur over on the dao layer.
		
		// So, for project-1, use Hibernate, because it will make things a lot easier
		// Just get past the initial setup of Hibernate and the mapping of Entities
	}

}

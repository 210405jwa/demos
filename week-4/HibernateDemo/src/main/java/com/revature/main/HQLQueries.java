package com.revature.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.models.Pirate;
import com.revature.models.Ship;
import com.revature.utils.SessionUtility;

public class HQLQueries {

	public static void main(String[] args) {
		
		Session session = SessionUtility.getSessionFactory().openSession();
		
		// Setting up a query:
		// You don't use column names or table names from the database w/ HQL
		// HQL is purely based on the class property names and class name itself
		Query shipQuery = session.createQuery("FROM Ship s");
		List<Ship> ships = shipQuery.getResultList();

		System.out.println(ships);
		
		Ship ship1 = (Ship) session.createQuery("FROM Ship s WHERE s.id = :id")
							.setParameter("id", 1).getSingleResult();
		
		System.out.println("Pirates belonging to ship1: " + ship1.getPirates());
		
		// Get the first pirate from ship1
		Pirate firstPirate = ship1.getPirates().get(0);
		
		// Get the ship the pirate belongs to, which will obviously be ship1
		System.out.println(firstPirate.getShip());
		
		// So the fact we can do this very easily on both sides is due to the bidirectional mapping we set up
		
		// But if we remove the bidirectional... so that we only have the @ManyToOne mapping on Pirate
		
		// We would do something like below:
		// Get all of the pirates belonging to ship w/ id of 1
		List<Pirate> pirates = session.createQuery("SELECT p FROM Pirate p JOIN p.ship s WHERE s.id = :id")
			.setParameter("id", 1).getResultList();
		
		System.out.println("HQL way of getting all pirates w/ ship id 1: " + pirates);
	}

}

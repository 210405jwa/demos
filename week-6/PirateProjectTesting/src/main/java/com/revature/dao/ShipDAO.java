package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Ship;
import com.revature.template.ShipTemplate;

@Repository
public class ShipDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional // By default, will use the outer transaction or create a new transaction if none
	// is available
	public Ship getShipById(int id) {
		Session session = sessionFactory.getCurrentSession(); // Grabs the contextual session
		
		Ship ship = session.get(Ship.class, id);
		
		return ship;
	}

	@Transactional
	public Ship addShip(ShipTemplate shipTemplate) {
		Session session = sessionFactory.getCurrentSession();
		
		Ship newShip = new Ship(0, shipTemplate.getShipName());
		
		session.persist(newShip); // The ship id should change from 0 to an actual database value
		// since newShip will now be persistent
		
		return newShip;
	}
	
}

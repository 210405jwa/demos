package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.ShipDAO;
import com.revature.exception.ShipCreationException;
import com.revature.exception.ShipNotFoundException;
import com.revature.model.Ship;
import com.revature.template.ShipTemplate;

@Service
//@Scope("prototype") // Specify scope using @Scope annotation
public class ShipService {

	@Autowired
	private ShipDAO shipDAO;
	
	@Transactional
	public Ship getShipById(int id) throws ShipNotFoundException {
		Ship ship = shipDAO.getShipById(id);
		
		if (ship == null) {
			throw new ShipNotFoundException();
		}
		
		return ship;
	}
	
	@Transactional
	public Ship addShip(ShipTemplate shipTemplate) throws ShipCreationException {
		if (shipTemplate.getShipName().trim().equals("")) {
			throw new IllegalArgumentException("You cannot have a blank ship name");
		}
		
		Ship ship = shipDAO.addShip(shipTemplate);
		
		if (ship.getId() == 0) {
			throw new ShipCreationException("Ship was not able to be created");
		}
		
		return ship;
	}
	
}

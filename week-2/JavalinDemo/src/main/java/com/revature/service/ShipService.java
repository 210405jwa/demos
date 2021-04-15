package com.revature.service;

import com.revature.dao.ShipRepository;
import com.revature.dto.PostShipDTO;
import com.revature.exceptions.AddShipException;
import com.revature.exceptions.DatabaseException;
import com.revature.model.Ship;

public class ShipService {

	private ShipRepository shipRepository;
	
	public ShipService() {
		super();
		this.shipRepository = new ShipRepository();
	}
	
	public ShipService(ShipRepository shipRepository) {
		this.shipRepository = shipRepository;
	}
	
	// Add a ship
	public Ship addShip(PostShipDTO shipDTO) throws DatabaseException, AddShipException {
		if (shipRepository.getShipByName(shipDTO.getShipName()) != null) {
			throw new AddShipException("User tried to add a ship that already exists with that name");
		}
		
		if (shipDTO.getShipName().trim().equals("")) {
			throw new AddShipException("User tried to add a ship with a blank name");
		}
		
		return shipRepository.addShip(shipDTO);
	}

}

package com.revature.service;

import com.revature.dao.ShipRepository;
import com.revature.dto.PostShipDTO;
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
	public Ship addShip(PostShipDTO shipDTO) {
		return null;
	}

}

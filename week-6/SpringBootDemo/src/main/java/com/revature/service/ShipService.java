package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.ShipRepository;
import com.revature.entity.Ship;
import com.revature.template.ShipTemplate;

@Service
public class ShipService {

	@Autowired
	private ShipRepository shipRepository;
	
	@Transactional
	public Ship addShip(ShipTemplate shipTemplate) {
		Ship ship = new Ship(0, shipTemplate.getShipName(), shipTemplate.getPrice());
		
		shipRepository.save(ship);
		
		if (ship.getId() == 0) {
			throw new RuntimeException("Couldn't insert ship into the database");
		}
		
		return ship;
	}

	@Transactional
	public Ship getShipByShipName(String name) {
		Optional<Ship> opt = shipRepository.findByShipName(name);
		
		if (opt.isEmpty()) {
			throw new RuntimeException("Ship with name: " + name + " was not found");
		}
		
		return opt.get();
	}
	
	@Transactional
	public List<Ship> getShipsByPriceGreaterThan(int price) {
		List<Ship> ships = shipRepository.findByPriceGreaterThan(price);
		
		if (ships.size() == 0) {
			throw new RuntimeException("No ships found with price greater than " + price);
		}
		
		return ships;
	}
	
	@Transactional
	public Ship updatePriceOfShipById(int id, int price) {
		Optional<Ship> shipOpt = shipRepository.findById(id);
		
		if (shipOpt.isEmpty()) {
			throw new RuntimeException("Ship id " + id + " does not exist");
		}
		
		Ship ship = shipOpt.get();
		
		ship.setPrice(price);
		
		return ship;
	}

}

package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Ship;
import com.revature.service.ShipService;
import com.revature.template.ShipTemplate;

@RestController
public class ShipController {

	@Autowired
	private ShipService shipService;
	
	@GetMapping("test")
	public /* @ResponseBody is implicitly added here whenever we do @RestController */String test() {
		return "Hi";
	}
	
	@PostMapping("ship")
	public Ship addShip(@RequestBody ShipTemplate shipTemplate) {
		Ship ship = shipService.addShip(shipTemplate); // the ship returned to the controller here is "detached" 
		// according to Hibernate, because we're outside of the "transaction" through @Transactional
		// @Transactional creates a transaction and a "contextual ORM session" for that operation
		return ship;
	}
	
	@GetMapping("ship/{shipName}")
	public Ship getShipByShipName(@PathVariable("shipName") String name) {
		return shipService.getShipByShipName(name);
	}
	
}

package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.exception.ShipCreationException;
import com.revature.exception.ShipNotFoundException;
import com.revature.model.Ship;
import com.revature.services.ShipService;
import com.revature.template.MessageTemplate;
import com.revature.template.ShipTemplate;

@Controller // This is a stereotype annotation, just like @Component, @Service, @Repository
// What those annotations are for, is to have Spring register it as a Spring Bean
public class ShipController {
	
	@Autowired
	private ShipService shipService;
	
	@GetMapping(path = "ship/{id}")
	public ResponseEntity<Object> getShipById(@PathVariable("id") int id) {
		
		try {
			
			Ship ship = shipService.getShipById(id);
			
			return ResponseEntity.status(200).body(ship);
			
		} catch (ShipNotFoundException e) {
			
			return ResponseEntity.status(404).body(new MessageTemplate("Ship with id " + id + " was not found"));
		
		}
		
	}
	
	@PostMapping(path = "ship")
	public ResponseEntity<Object> addShip(@RequestBody ShipTemplate shipTemplate) {
		
		try {
			Ship ship = shipService.addShip(shipTemplate);
			
			return ResponseEntity.status(201).body(ship);
		} catch (ShipCreationException e) {
			
			return ResponseEntity
					.status(500)
					.body(new MessageTemplate("Unable to create ship in the database!"));
		}
		
	}
	
}

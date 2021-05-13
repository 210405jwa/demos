package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.annotations.LoggedInOnly;
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
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
		
	@GetMapping(path = "ship/{id}")
	@LoggedInOnly
	public ResponseEntity<Object> getShipById(@PathVariable("id") int id) {
		
		/*
		 * The code below seems like a cross cutting concern
		 * We probably want to check if a user is logged in on MANY different endpoints
		 * In order for them to access that data
		 * So we can create an aspect w/ a piece of advice inside of that aspect
		 * That will control whether or not the user has access to that endpoint method
		 */
//		HttpSession session = request.getSession(false); // false because we don't want a new session
//		// to be created if the session does not exist
//		if (session == null) {
//			return ResponseEntity.status(401).body(new MessageTemplate("User is not logged in!"));
//		} else {
//			System.out.println(session.getAttribute("loggedInUser"));
//		}
		
		try {
			
			Ship ship = shipService.getShipById(id);
			
			return ResponseEntity.status(200).body(ship);
			
		} catch (ShipNotFoundException e) {
			
			return ResponseEntity.status(404).body(new MessageTemplate("Ship with id " + id + " was not found"));
		
		}
		
	}
	
	@PostMapping(path = "ship")
	@LoggedInOnly
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

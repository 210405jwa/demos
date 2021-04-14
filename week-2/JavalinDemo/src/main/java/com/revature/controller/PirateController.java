package com.revature.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.model.Pirate;
import com.revature.service.PirateService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class PirateController implements Controller {

	private Logger logger = LoggerFactory.getLogger(PirateController.class);
	private PirateService pirateService;
	
	public PirateController() {
		this.pirateService = new PirateService();
	}
	
	private Handler getPirates = ctx -> {
		ctx.html("<h1>getPirates Handler</h1>");
	};
	
	private Handler getPiratesById = ctx -> {
		String id = ctx.pathParam("id");
		
		Pirate pirate = pirateService.getPirateById(id);
		
		ctx.json(pirate); // Takes any Java Object and serializes it into JSON
		// Serialization means taking an object and converting it into some sendable data
		ctx.status(200); // 200 means successful, in general
	};
	
	private Handler addPirate = ctx -> {
		Pirate pirate = ctx.bodyAsClass(Pirate.class);
		logger.info("Pirate resource: " + pirate + " received from client");
		
		// Pirate insertedPirate = pirateService.addPirate(pirate);
		
		ctx.status(201); // 201 CREATED
//		ctx.json(insertedPirate);
	};
	
	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/pirates", getPirates);
		app.get("/pirates/:id", getPiratesById); // id is a 'path parameter'
		app.post("/pirates", addPirate);
	}

}

package com.revature.controller;

import com.revature.model.Pirate;
import com.revature.service.PirateService;

import io.javalin.Javalin;
import io.javalin.http.ExceptionHandler;
import io.javalin.http.Handler;

public class PirateController implements Controller {

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
	
	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/pirates", getPirates);
		app.get("/pirates/:id", getPiratesById); // id is a 'path parameter'
	}

}

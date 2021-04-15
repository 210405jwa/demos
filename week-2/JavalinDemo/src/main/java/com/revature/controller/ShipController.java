package com.revature.controller;

import com.revature.dto.PostShipDTO;
import com.revature.model.Ship;
import com.revature.service.ShipService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ShipController implements Controller {

	private ShipService shipService;
	
	public ShipController() {
		this.shipService = new ShipService();
	}
	
	private Handler addPirateShip = ctx -> {
		PostShipDTO pirateDTO = ctx.bodyAsClass(PostShipDTO.class);
		
		Ship ship = this.shipService.addShip(pirateDTO);
		
		ctx.json(ship);
		ctx.status(201);
	};
	
	@Override
	public void mapEndpoints(Javalin app) {
		app.post("/ships", addPirateShip);
	}

}

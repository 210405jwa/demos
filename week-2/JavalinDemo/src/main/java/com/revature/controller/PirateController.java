package com.revature.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dto.PostPirateDTO;
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
		
	private Handler addPirate = ctx -> {
		PostPirateDTO pirateDTO = ctx.bodyAsClass(PostPirateDTO.class);
		String shipId = ctx.pathParam("shipid");
		
		Pirate insertedPirate = pirateService.addPirate(shipId, pirateDTO);
		
		ctx.status(201); // 201 CREATED
		ctx.json(insertedPirate);
	};
	
	@Override
	public void mapEndpoints(Javalin app) {
		app.post("/ships/:shipid/pirates", addPirate);
	}

}

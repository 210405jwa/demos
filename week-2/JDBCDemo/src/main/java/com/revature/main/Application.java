package com.revature.main;

import java.util.List;

import com.revature.exceptions.DatabaseException;
import com.revature.exceptions.PirateNotFoundException;
import com.revature.model.Pirate;
import com.revature.service.PirateService;

public class Application {

	public static void main(String[] args) {
		
		PirateService pirateService = new PirateService();
		
		try {
			List<Pirate> pirates = pirateService.getPirates();
			System.out.println(pirates);
			
			System.out.println();
			
			Pirate pirate = pirateService.getPirateById(2);
			System.out.println(pirate);
			
			Pirate pirateToInsert = new Pirate(0, "Jack", "Sparrow");
			Pirate insertedPirate = pirateService.addPirate(pirateToInsert);
			System.out.println("Inserted Pirate: " + insertedPirate);
		} catch (DatabaseException e1) {
			System.out.println(e1.getMessage());
		} catch (PirateNotFoundException e2) {
			System.out.println(e2.getMessage());
		}
		

	}

}

package com.revature.dao;

import com.revature.model.Pirate;

public class PirateRepository {

	public Pirate getPirateById(int id) {
		if (id == 1) {
			return new Pirate(1, "Edward", "Thatch");
		}
		
		return null;
	}
	// Perform database operations such as retrieving a pirate, updating a pirate's data, 
	// adding a new pirate, etc.
}

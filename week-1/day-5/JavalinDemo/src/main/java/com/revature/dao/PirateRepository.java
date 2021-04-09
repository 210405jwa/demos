package com.revature.dao;

import com.revature.model.Pirate;

public class PirateRepository {

	public Pirate getPirateById(int id) {
		if (id == 1) {
			return new Pirate("Blackbeard", "Queen Anne's Revenge", 10000, "Captain");
		}
		
		return null;
	}
	// Perform database operations such as retrieving a pirate, updating a pirate's data, 
	// adding a new pirate, etc.
}

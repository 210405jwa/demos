package com.revature.service;

import com.revature.dao.PirateRepository;
import com.revature.exceptions.BadParameterException;
import com.revature.exceptions.PirateNotFoundException;
import com.revature.model.Pirate;

public class PirateService {

	private PirateRepository pirateRepository;
	
	public PirateService() {
		this.pirateRepository = new PirateRepository();
	}
	
	// Normally we use the no-args in the normal functioning of our application
	// But when we're testing, we need this constructor to "inject" our mock object into this service
	public PirateService(PirateRepository pirateRepository) {
		this.pirateRepository = pirateRepository;
	}
	
	public Pirate getPirateById(String stringId) throws BadParameterException, PirateNotFoundException {
		try {
			int id = Integer.parseInt(stringId);
			
			Pirate pirate = pirateRepository.getPirateById(id);
			
			if (pirate == null) {
				throw new PirateNotFoundException("Pirate with id of " + id + " was not found");
			}
			
			return pirate;
		} catch (NumberFormatException e) {
			throw new BadParameterException("Pirate id must be an int. User provided " + stringId);
		}
	}
	
}

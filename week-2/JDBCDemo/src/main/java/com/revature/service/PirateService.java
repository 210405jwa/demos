package com.revature.service;

import java.util.List;

import com.revature.dao.PirateDAO;
import com.revature.exception.PirateCreationException;
import com.revature.exceptions.DatabaseException;
import com.revature.exceptions.PirateNotFoundException;
import com.revature.model.Pirate;

public class PirateService {

	// This is a dependency of PirateService
	private PirateDAO pirateDAO;
	
	public PirateService() {
		this.pirateDAO = new PirateDAO();
	}
	
	// For passing in the mocked pirateDAO whenever I am unit testing and utilizing Mockito to mock my dependency
	public PirateService(PirateDAO pirateDAO) {
		this.pirateDAO = pirateDAO;
	}
	
	public List<Pirate> getPirates() throws DatabaseException {
		return pirateDAO.getPirates();
	}
	
	public Pirate getPirateById(int id) throws PirateNotFoundException, DatabaseException {
		return pirateDAO.getPirateById(id);
	}
	
	public Pirate addPirate(Pirate pirate) throws DatabaseException, PirateCreationException {
		return pirateDAO.addPirate(pirate);
	}
}

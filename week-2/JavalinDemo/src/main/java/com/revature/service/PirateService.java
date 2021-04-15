package com.revature.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.PirateRepository;
import com.revature.dto.PostPirateDTO;
import com.revature.exceptions.AddPirateException;
import com.revature.exceptions.BadParameterException;
import com.revature.exceptions.DatabaseException;
import com.revature.exceptions.PirateNotFoundException;
import com.revature.model.Pirate;
import com.revature.util.ConnectionUtil;

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
	
	public Pirate addPirate(String stringId, PostPirateDTO pirateDTO) throws BadParameterException, DatabaseException, AddPirateException {
		try {
			Connection connection = ConnectionUtil.getConnection(); // Have control over a connection object here
			this.pirateRepository.setConnection(connection); // pass the connection into the DAO
			connection.setAutoCommit(false); // Turn off autocommit so we have control over commit v. not committing
			
			if (pirateDTO.getFirstName().trim().equals("") || pirateDTO.getLastName().trim().equals("")) {
				throw new AddPirateException("Pirate first/last names cannot be blank");
			}
			
			try {
				int shipId = Integer.parseInt(stringId);
				
				Pirate pirate = pirateRepository.addPirate(shipId, pirateDTO);
				
				connection.commit(); // This is when changes will actually be persisted
				return pirate;
			} catch (NumberFormatException e) {
				throw new BadParameterException("Ship id must be an int. User provided " + stringId);
			}
			
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong when trying to get a connection. "
					+ "Exception message: " + e.getMessage());
		}

	}
	
}

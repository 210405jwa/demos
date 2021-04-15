package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.dto.PostPirateDTO;
import com.revature.exceptions.DatabaseException;
import com.revature.model.Pirate;
import com.revature.util.ConnectionUtil;

public class PirateRepository {

	// Transaction management
	// A good practice might be to handle a transaction over in the service layer. Here is where we might perform
	// individual database operations
	
	// So, I will create a constructor that accepts an external connection object into this DAO instead
	// and then we'll make use of that
	private Connection connection;
	
	public PirateRepository() {
		super();
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Pirate addPirate(int shipId, PostPirateDTO pirateDTO) throws DatabaseException {
		
		try {
			String sql = "INSERT INTO pirates (first_name, last_name, ship_id) VALUES (?, ?, ?)";
			
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, pirateDTO.getFirstName());
			pstmt.setString(2, pirateDTO.getLastName());
			pstmt.setInt(3, shipId);
			
			int recordsAdded = pstmt.executeUpdate();
			
			if (recordsAdded != 1) {
				throw new DatabaseException("Couldn't add a pirate to the database");
			}
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				Pirate newPirate = new Pirate(id, pirateDTO.getFirstName(), pirateDTO.getLastName());
				return newPirate;
			} else {
				throw new DatabaseException("Pirate id was not generated, and therefore adding a pirate failed");
			}
			
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with the database. "
					+ "Exception message: " + e.getMessage());
		}
		
	}
}

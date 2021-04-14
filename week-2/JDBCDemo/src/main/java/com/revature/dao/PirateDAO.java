package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.exception.PirateCreationException;
import com.revature.exceptions.DatabaseException;
import com.revature.exceptions.PirateNotFoundException;
import com.revature.model.Pirate;
import com.revature.util.ConnectionUtil;

public class PirateDAO {

	public List<Pirate> getPirates() throws DatabaseException {
		List<Pirate> listOfPirates = new ArrayList<>();
		
		try (Connection connection = ConnectionUtil.getConnection()) {
			
			// Define the SQL query
			String sql = "SELECT * FROM pirates";
			
			// Create a Statement OR PreparedStatement object 
			// USING the connection object that we obtained from DriverManager inside of our ConnectionUtil class
			Statement stmt = connection.createStatement();
			
			// Execute the query
			ResultSet rs = stmt.executeQuery(sql);
			
			// Iterate through our ResultSet
			while (rs.next()) {
//				int pirateId = rs.getInt(1);
//				String firstName = rs.getString(2);
//				String lastName = rs.getString(3);
				
				// Alternative syntax
				int pirateId = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				
				Pirate pirate = new Pirate(pirateId, firstName, lastName);
				listOfPirates.add(pirate);
			}
			
		} catch (SQLException e) {
			throw new DatabaseException("Something happened with the database. Exception message is: " + e.getMessage());
		}
		
		return listOfPirates;
	}

	public Pirate getPirateById(int id) throws PirateNotFoundException, DatabaseException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM pirates p WHERE p.id = ?";
			
			// In the above example with getPirates, we used a Statement object. We created it
			// by doing connection.createStatement()
			// Here, instead, we will be doing connection.prepareStatement(String sql) in order to create a 
			// preparedStatement
			
			// PreparedStatement v. Statement
			// 1. Statement is typically worse for security, especially in the case of SQL injection
			// SQL injection is where you have "unsanitized input" that an attacker can potentially exploit
			// and execute arbitrary SQL statements on your database.
			// 2. PreparedStatement provides a template that is basically pre-compiled, so that you don't run
			// into this issue of SQL injection. You have a template already that you can just fill in the
			// necessary data for, and nothing else
			// 3. Using PreparedStatement is better practice for avoiding the issue of SQL injection
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			// Execute query
			ResultSet rs = pstmt.executeQuery();
			
			// We're just retrieving a single Pirate by their ID, so we don't need a while loop to iterate
			// over the result set. So, here we can just use if(rs.next()) { ... }
			if (rs.next()) {
				int pirateId = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				
				return new Pirate(pirateId, firstName, lastName);
			}
			
		} catch (SQLException e) {
			throw new DatabaseException("Something happened with the database. Exception message is: " + e.getMessage());
		}
		
		throw new PirateNotFoundException("Pirate with id " + id + " was not found.");
	}

	public Pirate addPirate(Pirate pirate) throws DatabaseException, PirateCreationException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO pirates (first_name, last_name) VALUES (?, ?)";
			
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	
			pstmt.setString(1, pirate.getFirstName());
			pstmt.setString(2, pirate.getLastName());
			
			// For DML, such as INSERT, UPDATE, DELETE, you would use something like execute UPDATE typically
			// instead of executeQuery
			
			int recordsModified = pstmt.executeUpdate();
			
			if (recordsModified != 1) {
				throw new PirateCreationException("Pirate was not able to be inserted into the database");
			}
		
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				pirate.setId(generatedKeys.getInt(1));
			} else {
				throw new PirateCreationException("No ID was able to be obtained when trying to insert a pirate. "
						+ "Pirate insertion failed");
			}
			
			return pirate;
			
		} catch (SQLException e) {
			throw new DatabaseException("Something happened with the database. Exception message is: " + e.getMessage());
		}
	}

}

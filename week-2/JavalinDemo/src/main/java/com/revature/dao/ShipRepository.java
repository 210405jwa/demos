package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.dto.PostShipDTO;
import com.revature.exceptions.AddShipException;
import com.revature.exceptions.DatabaseException;
import com.revature.model.Ship;
import com.revature.util.ConnectionUtil;

public class ShipRepository {

	public Ship addShip(PostShipDTO shipDTO) throws DatabaseException, AddShipException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO ships (ship_name) VALUES (?)";
			
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, shipDTO.getShipName());
			
			int recordsAdded = pstmt.executeUpdate();
			
			if (recordsAdded != 1) {
				throw new DatabaseException("Couldn't add a ship to the database");
			}
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				Ship newShip = new Ship(id, shipDTO.getShipName());
				newShip.setPirates(new ArrayList<>());
				return newShip;
			} else {
				throw new DatabaseException("Ship id was not generated, and therefore adding a ship failed");
			}
			
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong when trying to get a connection. "
					+ "Exception message: " + e.getMessage());
		}
	}

	public Ship getShipByName(String shipName) throws DatabaseException {
		Ship ship = null;
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ships s WHERE s.ship_name = ?";
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, shipName);
			
			ResultSet rs = pstmt.executeQuery();
			
			// Using if (rs.next()) instead of while, since we are retrieving only 1 result
			if(rs.next()) {
				int id = rs.getInt("id");
				String retrievedShipName = rs.getString("ship_name");
				ship = new Ship(id, retrievedShipName);
			}
			
			return ship;
			
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong when trying to get a connection. "
					+ "Exception message: " + e.getMessage());
		}
	}
	
}

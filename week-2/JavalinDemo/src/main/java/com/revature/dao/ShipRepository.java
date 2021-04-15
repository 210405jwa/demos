package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.dto.PostShipDTO;
import com.revature.exceptions.AddShipException;
import com.revature.exceptions.DatabaseConnectionException;
import com.revature.model.Ship;
import com.revature.util.ConnectionUtil;

public class ShipRepository {

//	public Ship addShip(PostShipDTO shipDTO) throws DatabaseConnectionException, AddShipException {
//		try (Connection connection = ConnectionUtil.getConnection()) {
//			String sql = "INSERT INTO ships (ship_name) VALUES (?)";
//			
//			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			
//			pstmt.setString(1, shipDTO.getShipName());
//			
//			int recordsAdded = pstmt.executeUpdate();
//			
//			if (recordsAdded != 1) {
//				throw new AddShipException("Couldn't add a ship to the database");
//			}
//			
//			ResultSet rs = pstmt.getGeneratedKeys();
//			if (rs.next()) {
//				int id = rs.getInt(1);
//				Ship newShip = new Ship(id, shipDTO.getShipName());
//				newShip.setPirates(new ArrayList<>());
//				return newShip;
//			}
//			
//		} catch (SQLException e) {
//			throw new DatabaseConnectionException("Something went wrong when trying to get a connection. "
//					+ "Exception message: " + e.getMessage());
//		}
//	}
	
}

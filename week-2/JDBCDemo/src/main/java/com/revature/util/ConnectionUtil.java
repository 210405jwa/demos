package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.mariadb.jdbc.Driver;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {
		// First step: register the MariaDB driver w/ the DriverManager class
		DriverManager.registerDriver(new Driver());
		
		// Seconds step: have our credentials ready
		String username = "root";
		String password = "password";
		
		// Provide a connection string
		String url = "jdbc:mariadb://localhost:3307/my_first_database";
		
		return DriverManager.getConnection(url, username, password);
	}
	
}

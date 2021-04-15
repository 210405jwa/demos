package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.mariadb.jdbc.Driver;

public class ConnectionUtil {

	private ConnectionUtil() {
	}
	
	public static Connection getConnection() throws SQLException {
		
		Driver mariaDBDriver = new Driver();
		DriverManager.registerDriver(mariaDBDriver);
		
		// It's better to not hardcode your credentials
		// Instead, there are two good alternative options:
		// 1. Using a properties file stored locally on your server (make sure not to push)
		// 2. Use environment variables
		
//		String username = "root";
//		String password = "password";
//		String connectionString = "jdbc:mariadb://localhost:3307/my_first_database";
		
		/*
		 * Environment variable approach
		 */
		String username = System.getenv("db_username");
		String password = System.getenv("db_password");
		String connectionString = System.getenv("db_url");
		
		return DriverManager.getConnection(connectionString, username, password);
	}

}

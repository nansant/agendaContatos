package com.example.demo.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() {
		
		try {
			
			var host = "jdbc:postgresql://localhost:5436/apicontatos";
			var user = "admin";
			var pass = "admin123";
			
			return DriverManager.getConnection(host, user, pass);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}

package com.project.bankManagmentSystem;

import java.sql.*;

public class Conn {
	public Connection conn; 
	public Statement stmt;

	public Conn() {
		try {
			// assign to the class field, not a local variable
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "root");
			stmt = conn.createStatement();
		} catch (Exception e) {
			System.out.println("Database connection error: " + e);
		}
	}
}
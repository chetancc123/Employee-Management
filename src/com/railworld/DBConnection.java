package com.railworld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
 static Connection con;
 
 public static Connection cerateDBConnection() {
	 
	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	 
 	
 	 Connection con= null;
 	
 	
 	
 	 try {
		   con =	DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDB", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 return con;
 }
}

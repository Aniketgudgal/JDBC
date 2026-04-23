package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionApplication 
{
	public static void main(String[] args)
	{
		try {
			com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_123", "root", "Aniket@5867");
			if(con != null)
			{
				System.out.println("Connected successfully");
			}
			else 
			{
				System.out.println("Problem to connect");
			}
		} catch (SQLException e) {
			System.out.println("Exception "+e);
		}
		
	}

}

package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertDataInterface {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_123","root","Aniket@5867");
			if(con != null)
			{
				System.out.println("Connected");
				PreparedStatement spt = con.prepareStatement("select * from employee");
				ResultSet rest = spt.executeQuery();
				System.out.println("___________________________________________________________________________________________");
				while(rest.next())
				{
					System.out.println(rest.getInt(1)+"\t| "+rest.getString(2)+"\t| "+rest.getInt(3)+"\t| "+rest.getInt(4)+"\t| "+rest.getInt(5));
				}
				
			}
			else {
				System.out.println("Problem to connect");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

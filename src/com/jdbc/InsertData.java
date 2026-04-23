package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_123","root","Aniket@5867");
		if(cn != null)
		{
			System.out.println("Connected database");
			Statement stms = cn.createStatement();
			int res = stms.executeUpdate("insert into empInfo values (51,'An',500)");
			if(res > 0)
			{
				System.out.println("Data inserted");
			}
			else
			{
				System.out.println("Proble to insert");
			}
		}
		else
		{
			System.out.println("Problem to connect");
		}
	}

}

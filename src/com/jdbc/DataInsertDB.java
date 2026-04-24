package com.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class DataInsertDB {

	public static void main(String[] args) throws SQLException, IOException {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		File file = new File("");
		String path = file.getAbsolutePath()+"\\src\\dbconfig.properties";
		FileInputStream fInputStream = new FileInputStream(path);
		Properties properties = new Properties();
		properties.load(fInputStream);
		String url  = properties.getProperty("url");
		String uname  = properties.getProperty("uname");
		String pass  = properties.getProperty("pass");
		Connection connection = DriverManager.getConnection(url, uname, pass);
		if(connection != null)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the name: ");
			String name = scanner.next();
			System.out.print("Enter the department id: ");
			Integer dept_id = null;
			String inp = scanner.next();
			if(!inp.equalsIgnoreCase("null"))
			{
				dept_id = Integer.parseInt(inp);	
			}
			System.out.print("Enter the salary: ");
			int salary = scanner.nextInt();
			System.out.print("Enter the joining year: ");
			int year = scanner.nextInt();
			PreparedStatement  pmt  = connection.prepareStatement("insert into employee values('0',?,?,?,?)");
			pmt.setString(1, name);
			if(dept_id == null)
			{
				pmt.setNull(2, java.sql.Types.INTEGER);
			}
			else
			{
				pmt.setInt(2, dept_id);
			}
			pmt.setInt(3, salary);
			pmt.setInt(4, year);
			int result = pmt.executeUpdate();
			if(result > 0)
			{
				System.out.println("Data inserted into DB");
			}
			else
			{
				System.out.println("Problem to insert");
			}
		}
		else
		{
			System.out.print("Problem to connect");
		}
	}

}

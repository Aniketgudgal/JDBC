package com.jdbc.search;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class FetchByColumn {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		File file = new File("");
		String path  = file.getAbsolutePath()+"\\src\\dbconfig.properties";
		FileInputStream fim  = new FileInputStream(path);
		Properties ps  = new Properties();
		ps.load(fim);
		String url = ps.getProperty("url");
		String uname = ps.getProperty("uname");
		String driver  = ps.getProperty("driver");
		String pass = ps.getProperty("pass");
		Class.forName(driver);
		Connection cn  = DriverManager.getConnection(url,uname,pass);
		if(cn != null)
		{
			System.out.println("Connected");
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the table name: ");
			String tname = sc.next();
			System.out.print("Enter the first column name: ");
			String col1 = sc.next();
			System.out.print("Enter second column name: ");
			String col2 = sc.next();
			String query  = "select "+col1 +", "+col2+ " from "+tname;
			PreparedStatement statement = cn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			}
		}
		else
		{
			System.out.println("Not Connected");
		}
	}

}

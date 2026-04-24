package com.jdbc.search;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class SearchData {

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException{
		File f = new File("");
		String path = f.getAbsolutePath()+"\\src\\dbconfig.properties";
		FileInputStream fm = new FileInputStream(path);
		Properties ps = new Properties();
		ps.load(fm);
		String driver = ps.getProperty("driver");
		String uname = ps.getProperty("uname");
		String pass = ps.getProperty("pass");
		String url = ps.getProperty("url");
		Class.forName(driver);
		Connection cn  = DriverManager.getConnection(url, uname, pass);
		if(cn != null)
		{
			PreparedStatement pstm = cn.prepareStatement("Select * from employee where emp_id = ?");
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the employee id: ");
			int id = sc.nextInt();
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+ "\t"+rs.getString(2)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5));
			}
		}
		else
		{
			System.out.print("Proble to connect");
		}
	}

}

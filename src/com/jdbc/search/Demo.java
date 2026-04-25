package com.jdbc.search;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Demo {

	public static void main(String[] args) throws SQLException,IOException, FileNotFoundException {
		com.mysql.cj.jdbc.Driver db = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(db);
		File f = new File("");
		String path = f.getAbsolutePath()+"\\src\\dbconfig.properties";
		FileInputStream fs = new FileInputStream(path);
		Properties p = new Properties();
		p.load(fs);
		String  uname = p.getProperty("uname");
		String pass = p.getProperty("pass");
		String driver = p.getProperty("driver");
		String url = p.getProperty("url");
		Connection cn = DriverManager.getConnection(url,uname,pass);
		if(cn != null)
		{
			System.out.println("Connected");
//			PreparedStatement pf = cn.prepareStatement("create table if not exists abc(id int(2) primary key, name varchar(200), salary int(5) )");
//			int result = pf.executeUpdate();
//			if(result > 0)
//			{
//				System.out.println("Table created");
//
//			}
//			else
//			{
//				System.out.println("Not Created");
//			}
			java.sql.Statement statement = cn.createStatement();
			int result = statement.executeUpdate("drop table if exists abc");
			if(result > 0)
			{
				System.out.print("Table drop");
			}
			else
			{
				System.out.println("problem to drop table");
			}
			
		}
		else
		{
			System.out.println("Not Connected");
		}
	}

}

package com.jdbc.StoreDataFiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class StoreDataInFile {

	public static void main(String[] args) {
		try
		{
			File f = new File("");
			String path1 = f.getAbsolutePath()+"\\src\\dbconfig.properties";
			Properties p = new Properties();
			FileInputStream fs = new FileInputStream(path1);
			p.load(fs);
			String  driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String uname = p.getProperty("uname");
			String pass = p.getProperty("pass");
			Class.forName(driver);
			Connection cn = DriverManager.getConnection(url,uname, pass);
			if(cn != null)
			{
				System.out.println("Connected");
				PreparedStatement ps = cn.prepareStatement("Select * from employee");
				ResultSet rs = ps.executeQuery();
				String path = f.getAbsolutePath()+"\\fileData.txt";
				File f1 = new File(path);
				if(!f1.exists())
				{
					f1.createNewFile();
					System.out.println("Output file created");
				}
				FileWriter fw = new FileWriter(f1);
				BufferedWriter bf = new BufferedWriter(fw);
				while(rs.next())
				{
					String data  = rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(4)+", "+rs.getInt(5);
					bf.write(data);
					bf.newLine();
				}
				bf.close();
				fw.close();
				fs.close();
				System.out.println("Data write");
			}
			else
			{
				System.out.println("Problem to connect");
			}
			
		}
		catch(IOException  e)
		{
			System.out.print(e);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}

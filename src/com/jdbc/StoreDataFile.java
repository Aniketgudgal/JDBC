package com.jdbc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class StoreDataFile {
	public static void main(String[] args) throws Exception
	{
		com.mysql.cj.jdbc.Driver dm = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(dm);
		File f = new File("");
		String path = f.getAbsolutePath()+"\\src\\dbconfig.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String uname = p.getProperty("uname");
		String pass = p.getProperty("pass");
		Connection cn   = DriverManager.getConnection(url,uname, pass);
		if (cn != null) {
			File f1 = new File(f.getAbsoluteFile()+"\\dataStorage.txt");
			f1.createNewFile();
			FileWriter fw  = new FileWriter(f1,true);
			BufferedWriter bf  = new BufferedWriter(fw);
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM Employee");
			ResultSet resultSet = ps.executeQuery();
			String heading = "Id\tname\tdept_id\t\tsalary";
			bf.write(heading);
			bf.newLine();
			while(resultSet.next())
			{
				String opString = resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t\t"+resultSet.getInt(4);
				bf.write(opString);
				bf.newLine();
			}
			bf.close();
			fw.close();
			System.out.println("Data writed successfully");
		}
		else {
			System.out.println("problem to connect");
		}
	}
}

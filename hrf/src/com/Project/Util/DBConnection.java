package com.Project.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBConnection 
{
	final static String url = "com.mysql.jdbc.Driver";
	final static String user = "root";
	final static String password = "root";
	
	public Connection getConnection()
	{
		Connection conn = null;
			try 
			{
				Class.forName(url);
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirst_db", user, password);
			}
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		return conn;
	}
}

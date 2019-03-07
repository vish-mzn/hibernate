package com.Project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Project.Model.Registration;
import com.Project.Util.DBConnection;

public class SignInDAO extends DBConnection
{
	public  ArrayList<Registration> getUserList() 
	{
		ArrayList<Registration> list = new ArrayList<Registration>();
		
		Connection conn = getConnection();
		
		try 
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM login");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String fname =rs.getString(2);
				String lname =rs.getString(3);
				String email =rs.getString(4);
				String password =rs.getString(5);
				
				Registration registration = new Registration(fname, lname, email, password);
				
				list.add(registration);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		
		return list;
	}

}

package com.Project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Project.Model.Registration;
import com.Project.Util.DBConnection;

public class registrationDAO extends DBConnection
{
	public boolean setUserList(Registration obj) 
	{		
		Connection conn = getConnection();
		
		try 
		{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO login (firstname, lastname, email, password) VALUES (?,?,?,?)");
			ps.setString(1, obj.getFname());
			ps.setString(2, obj.getLname());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getPassword());
			int i = ps.executeUpdate();
			System.out.println(i+" row affected");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
}

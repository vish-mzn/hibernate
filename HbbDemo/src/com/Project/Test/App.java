package com.Project.Test;

import com.Project.DaoLayer.Dao;
import com.Project.Pojo.Laptop;

public class App 
{
	public static void main(String[] args) 
	{	
		Laptop l = new Laptop();
		l.setLid(321);
		l.setLname("Hewlwtt");
		
		Dao dao = new Dao();
		try
		{
			dao.delete(l);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			dao.closeEntityManagerFactory();
		}

	}
}

package com.Project.DaoLayer;

import com.Project.Base.EMBase;
import com.Project.Pojo.Laptop;
import com.Project.Pojo.Student;

public class Dao extends EMBase
{	
	
	public void input() 
	{
		try 
		{
			Laptop l = new Laptop();
			Student s = new Student();
			
			l.setLid(222);
			l.setLname("MacBook");
			
			em = getEntityManager();
			em.getTransaction().begin();
			//em.persist(s);
			em.persist(l);
			em.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeEntityManager();
		}
		
	}
	
	public void delete(Laptop l) 
	{
		try 
		{
			em = getEntityManager();
			em.getTransaction().begin();
			em.remove(l);
			em.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeEntityManager();
		}
		
	}
	
}

package com.Project.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.Project.Pojo.Laptop;
import com.Project.Pojo.Student;

public class App 
{
	public static EntityManagerFactory emf;
	public static EntityManager em;
	
	public static void main(String[] args) 
	{
		emf = Persistence.createEntityManagerFactory("persistence");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Laptop l = new Laptop();
		Student s = new Student();
		
		try
		{
			tx.begin();
			l.setLid(321);
			l.setLname("Hewlwtt");
			em.persist(l);
			tx.commit();
			
			tx.begin();
			s.setRoolno(21);
			s.setSname("Ankur");
			s.setSalary(35000);
			em.persist(s);
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
			emf.close();
		}

	}
	
}

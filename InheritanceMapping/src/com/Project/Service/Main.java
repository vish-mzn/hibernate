package com.Project.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Project.Model.NonTeachingStaff;
import com.Project.Model.TeachingStaff;

public class Main {

	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager( );
		
	    em.getTransaction( ).begin( );

	    TeachingStaff ts1=new TeachingStaff("Gopal","MSc MEd","Maths");
	    TeachingStaff ts2=new TeachingStaff("Manisha", "BSc BEd", "English");
	    
	    NonTeachingStaff nts1=new NonTeachingStaff("Satish", "Accounts");
	    NonTeachingStaff nts2=new NonTeachingStaff("Krishna", "Office Admin");
	    
	      em.persist(ts1);
		  em.persist(ts2);
		  em.persist(nts1);
		  em.persist(nts2);
		  
		  em.getTransaction().commit();
		  
		  em.close();
		  emf.close();
	    
	}

}

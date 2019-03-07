package com.hdfc.corebanking.dao.base;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HdfcBaseDao {
	
	/* EntityManagerFactory */
	protected EntityManagerFactory emf = null;

	/* EntityManager */
	protected EntityManager em = null;

	protected EntityManager getEntityManager() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory("persistence");
		}

		if (em == null || !em.isOpen()) {
			em = emf.createEntityManager();
		}
		return em;
	}

	public void closeEntityManagerFactory() {
		if (emf != null) {
			emf.close();
		}
	}

	protected void closeEntityManager() {
		if (em != null) {
			em.close();
		}
	}


}

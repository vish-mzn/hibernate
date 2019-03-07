package com.hdfc.corebanking.dao.onetomany;

import com.hdfc.corebanking.dao.base.HdfcBaseDao;

public class DepartmentDaoImpl extends HdfcBaseDao {

	public void createDepartment(Department department) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(department);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}

	public Department getDepartment(int id) {

		Department department = null;
		try {
			em = getEntityManager();
			department = em.find(Department.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return department;
	}

	public void createProfessor(Professor professor) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(professor);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}
	
	
	public Professor getProfessor(int id) {

		Professor professor = null;
		try {
			em = getEntityManager();
			professor = em.find(Professor.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return professor;
	}


}

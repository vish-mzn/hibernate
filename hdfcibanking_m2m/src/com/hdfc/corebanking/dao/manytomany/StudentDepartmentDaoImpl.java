package com.hdfc.corebanking.dao.manytomany;

import com.hdfc.corebanking.dao.base.HdfcBaseDao;
import com.hdfc.corebanking.model.Employee;

public class StudentDepartmentDaoImpl extends HdfcBaseDao {

	public void createStudentDepartment(Dept dept) {
		try {
			/* Persist entity */
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(dept);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}
	
	
	public void createStudentandAssignDepartment(Student stu){
		try{
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(stu);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
	}

}

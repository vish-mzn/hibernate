package com.hdfc.corebanking.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.hdfc.corebanking.dao.base.HdfcBaseDao;
import com.hdfc.corebanking.model.Employee;

public class EmployeeDao extends HdfcBaseDao{

	
	public void create(Employee employee) {
		try {
			/* Persist entity */
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(employee);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}

	public Employee getEmployee(int id) {
		try {
			/* Retrieve entity */
			em = getEntityManager();
			employee = em.find(Employee.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeEntityManager();
		}
		return employee;
	}

	public Employee updateEmployee(Employee employee) {
		Employee employeePojo = null;
		try {
			/* Update entity */
			em = getEntityManager();
			em.getTransaction().begin();
			employeePojo = em.find(Employee.class, employee.getIdEmployee());
			employeePojo.setFirstname(employee.getFirstname());
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeEntityManager();
		}
		return employeePojo;
	}

	public int deleteEmployee(int empId) {
		try {
			/* Remove entity */
			employee.setIdEmployee(empId);
			em = getEntityManager();
			em.getTransaction().begin();
			em.remove(employee);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			closeEntityManager();
		}
		return empId;
	}

	public List<Employee> listEmployee() {
		List<Employee> listEmployee = new ArrayList<Employee>();
		try {
			/* retrive entity */
			em = getEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("from Employee");
			listEmployee = (List<Employee>)query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeEntityManager();
		}
		return listEmployee;
	}

}
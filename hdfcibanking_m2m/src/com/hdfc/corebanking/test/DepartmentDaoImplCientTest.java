package com.hdfc.corebanking.test;

import java.util.ArrayList;
import java.util.List;

import com.hdfc.corebanking.dao.onetomany.Department;
import com.hdfc.corebanking.dao.onetomany.DepartmentDaoImpl;
import com.hdfc.corebanking.dao.onetomany.Professor;

public class DepartmentDaoImplCientTest {

	DepartmentDaoImpl departmentDaoImpl = new DepartmentDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DepartmentDaoImplCientTest departmentCientTest = new DepartmentDaoImplCientTest();
			departmentCientTest.createDepartmentandProfessor();
			// departmentCientTest.getDepartment();
			// departmentCient.updateDepartment();
			// employeeDaoTest.deleteEmployee();
			// employeeDaoTest.listEmployee();
			//departmentCientTest.createDepartment();
			//departmentCientTest.createProfessor();
			//departmentCientTest.getProfessorandDepartment();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void createDepartmentandProfessor() {
		try {

			Department department = new Department();
			department.setName("Mechanical");
			department.setCode("mech");

			List<Professor> listProfessor = new ArrayList<Professor>();

			Professor professor = new Professor();
			professor.setName("pm2");
			professor.setSalary(242);
			professor.setDepartment(department);
			listProfessor.add(professor);

			Professor professor1 = new Professor();
			professor1.setName("pm1");
			professor1.setSalary(7548);
			professor1.setDepartment(department);
			listProfessor.add(professor1);

			department.setListProfessor(listProfessor);

			departmentDaoImpl.createDepartment(department);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			departmentDaoImpl.closeEntityManagerFactory();
		}

	}

	void getDepartment() {
		try {
			Department department = departmentDaoImpl.getDepartment(34);
			System.out.println("Professor count..." + department.getListProfessor().size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			departmentDaoImpl.closeEntityManagerFactory();
		}
	}

	void createDepartment() {
		try {

			Department department = new Department();
			department.setName("Electrical and Electronic");
			department.setCode("EEE");
			departmentDaoImpl.createDepartment(department);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			departmentDaoImpl.closeEntityManagerFactory();
		}

	}
	
	
	void createProfessor() {
		try {

			Professor professor = new Professor();
			professor.setName("Sharma");
			professor.setSalary(10000);
			Department department = new Department();
			department.setId(2);
			professor.setDepartment(department);
			departmentDaoImpl.createProfessor(professor);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			departmentDaoImpl.closeEntityManagerFactory();
		}

	}
	
	
	void getProfessorandDepartment(){
		try {
			
			Professor professor = departmentDaoImpl.getProfessor(154);
			System.out.println("Department Name..." + professor.getDepartment().getName());
			
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		departmentDaoImpl.closeEntityManagerFactory();
	}
	}
}

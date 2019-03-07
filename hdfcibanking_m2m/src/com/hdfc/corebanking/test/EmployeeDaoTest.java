package com.hdfc.corebanking.test;

import java.util.List;

import com.hdfc.corebanking.dao.EmployeeDao;
import com.hdfc.corebanking.model.Employee;

public class EmployeeDaoTest {

	EmployeeDao employeeDao = new EmployeeDao();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			EmployeeDaoTest employeeDaoTest = new EmployeeDaoTest();
			// employeeDaoTest.createEmployee();
			// employeeDaoTest.getEmployee();
			employeeDaoTest.updateEmployee();
			// employeeDaoTest.deleteEmployee();
			employeeDaoTest.listEmployee();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void createEmployee() {
		try {
			/* Create and populate Entity */
			Employee employee = new Employee();
			employee.setFirstname("sdf");
			employee.setLastname("esdte");
			employee.setEmail("somesMail@gmail.com");
			employeeDao.create(employee);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			employeeDao.closeEntityManagerFactory();
		}
	}

	void getEmployee() {
		try {
			Employee e = employeeDao.getEmployee(1);
			System.out.println("Email..." + e.getEmail());
			System.out.println("Employee Id is ...." + e.getIdEmployee());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			employeeDao.closeEntityManagerFactory();
		}
	}

	void updateEmployee() {
		try {
			Employee employee = new Employee();
			employee.setIdEmployee(1);
			employee.setFirstname("Radha");

			Employee e = employeeDao.updateEmployee(employee);

			System.out.println("Employee Id is ...." + e.getIdEmployee());
			System.out.println("Email..." + e.getEmail());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			employeeDao.closeEntityManagerFactory();
		}
	}

	void deleteEmployee() {
		try {
			int empId = employeeDao.deleteEmployee(1);
			if (empId > 0) {
				System.out.println("Employee deletion successful");
			} else {
				System.out.println("Employee deletion unsuccessful");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			employeeDao.closeEntityManagerFactory();
		}
	}

	void listEmployee() {
		List<Employee> listEmployee = null;
		try {
			listEmployee = employeeDao.listEmployee();

			System.out.println("\n \nEmployee First Name" + "\t" + "Employee Last Name" + "\t" + "Employee Email");

			for (Employee e : listEmployee) {
				System.out.println(e.getFirstname() + "\t" + e.getLastname() + "\t" + e.getEmail() + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			employeeDao.closeEntityManagerFactory();
		}
	}

}

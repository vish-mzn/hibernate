package com.hdfc.corebanking.test;

import java.util.ArrayList;
import java.util.List;

import com.hdfc.corebanking.dao.manytomany.Dept;
import com.hdfc.corebanking.dao.manytomany.Student;
import com.hdfc.corebanking.dao.manytomany.StudentDepartmentDaoImpl;
import com.hdfc.corebanking.dao.onetomany.Professor;

public class StudentDepManytoManyTest {
	
	
	StudentDepartmentDaoImpl studentDepartmentDaoImpl = new StudentDepartmentDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			StudentDepManytoManyTest studentDepManytoManyTest = new StudentDepManytoManyTest();
			//studentDepManytoManyTest.createStudentDepartment();
			studentDepManytoManyTest.createStudentandAssignDepartment();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	void createStudentDepartment(){
		try {
			/*Dept dept = new Dept();
			dept.setCode("mech");
			dept.setName("Mechanical");*/
			
			Dept dept2 = new Dept();
			dept2.setCode("cs");
			dept2.setName("Computer Science");

			/*List<Student> listStudent = new ArrayList<Student>();

			Student s1 = new Student();
			s1.setName("stu1");
			listStudent.add(s1);

			Student s2 = new Student();
			s2.setName("stu2");
			listStudent.add(s2);

			dept.setStudents(listStudent);*/
			
			//sstudentDepartmentDaoImpl.createStudentDepartment(dept);
			studentDepartmentDaoImpl.createStudentDepartment(dept2);


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			studentDepartmentDaoImpl.closeEntityManagerFactory();
		}
	}
	
	void createStudentandAssignDepartment(){
		try {
			
			List<Dept> listDept = new ArrayList<Dept>();

			
			Student s1 = new Student();
			s1.setName("stu7");
			
			
			/*Dept dept = new Dept();
			dept.setId(1);
			listDept.add(dept);
			
			Dept dept1 = new Dept();
			dept1.setId(2);
			listDept.add(dept1);*/

			s1.setDepartment(listDept);
			
			studentDepartmentDaoImpl.createStudentandAssignDepartment(s1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			studentDepartmentDaoImpl.closeEntityManagerFactory();
		}

	}
	
	

}

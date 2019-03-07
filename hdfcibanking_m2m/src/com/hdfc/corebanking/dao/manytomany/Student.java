package com.hdfc.corebanking.dao.manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="stu")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deptSeqGen")
	@SequenceGenerator(name = "deptSeqGen", sequenceName = "DEPT_SEQ_GEN", initialValue = 1000, allocationSize = 1)
	private int id;
	private String name;
	private int age;
	
	@ManyToMany
	@JoinTable(name = "Student_Dept", joinColumns = @JoinColumn(name = "Stut_ID"), inverseJoinColumns = @JoinColumn(name = "DEPT_ID"))
	private Collection<Dept> departments;

	public Student() {
		departments = new ArrayList<Dept>();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public void setDepartments(Collection<Dept> departments) {
		this.departments = departments;
	}
	public Collection<Dept> getDepartments() {
		return departments;
	}

	public void setDepartment(Collection<Dept> departments) {
		this.departments = departments;
	}

	public String toString() {
		return "\n\nID:" + id + "\nName:" + name;
	}
}
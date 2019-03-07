package com.hdfc.corebanking.dao.manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class Dept {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stuSeqGen")
	@SequenceGenerator(name = "stuSeqGen", sequenceName = "STU_SEQ_GEN", initialValue = 1, allocationSize = 1)
	private int id;
	private String name;
	private String code;

	@ManyToMany(mappedBy = "departments")
	private Collection<Student> students;

	public Dept() {
		students = new ArrayList<Student>();
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

	public void setName(String deptName) {
		this.name = deptName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}

	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudent(Collection<Student> students) {
		this.students = students;
	}

	public String toString() {
		return "Department id: " + getId() + ", name: " + getName();
	}
}
package com.hdfc.corebanking.dao.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="d")
public class Department {
	@Id
	@GeneratedValue (strategy= GenerationType.SEQUENCE, generator="depSeqGen")
	@SequenceGenerator(name = "depSeqGen", sequenceName = "DEP_SEQ_GEN", initialValue=1, allocationSize=1)	
	private int id;
	private String name;
	private String code;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Professor> listProfessor = new ArrayList<Professor>();;

	public Department() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public List<Professor> getListProfessor() {
		return listProfessor;
	}

	public void setListProfessor(List<Professor> listProfessor) {
		this.listProfessor = listProfessor;
	}

	

	

}

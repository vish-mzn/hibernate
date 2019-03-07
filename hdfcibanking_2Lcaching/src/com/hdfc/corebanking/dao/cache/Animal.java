package com.hdfc.corebanking.dao.cache;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@Cacheable
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@TableGenerator(name = "animal_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@GeneratedValue(generator = "animal_gen", strategy = GenerationType.TABLE)
	private int idAnimal;

	public int getIdAnimal() {
		return this.idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

}
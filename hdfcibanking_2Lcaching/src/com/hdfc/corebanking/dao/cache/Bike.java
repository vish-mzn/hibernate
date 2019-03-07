package com.hdfc.corebanking.dao.cache;

import java.io.Serializable;

import org.hibernate.annotations.Cache;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable(false)
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)

public class Bike implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@TableGenerator(name = "bike_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@GeneratedValue(generator = "bike_gen", strategy = GenerationType.TABLE)
	private int idBike;

	public int getIdBike() {
		return this.idBike;
	}

	public void setIdBike(int idBike) {
		this.idBike = idBike;
	}

}
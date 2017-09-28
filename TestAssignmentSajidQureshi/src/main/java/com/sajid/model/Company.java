package com.sajid.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "COMPANY")
public class Company implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	private String Name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private Set<Office> offices;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private Set<Brand> brands;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private Set<Warehouse> warehouses;

	public Set<Brand> getBrands() {
		return brands;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public Set<Office> getOffices() {
		return offices;
	}

	public Set<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setOffices(Set<Office> offices) {
		this.offices = offices;
	}

	public void setWarehouses(Set<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + "]";
	}

}

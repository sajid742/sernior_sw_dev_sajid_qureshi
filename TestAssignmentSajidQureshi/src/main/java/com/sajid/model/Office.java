package com.sajid.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Office implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	private String name;

	@NotEmpty
	@ManyToOne
	(fetch = FetchType.LAZY)
	private Company company;

	@NotEmpty
	private String location;

	public Company getCompany() {
		return company;
	}

	public Integer getId() {
		return id;
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Office [id=" + id + "]";
	}

}

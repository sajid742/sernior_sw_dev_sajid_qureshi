package com.sajid.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Brand implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
	private Set<Product> products;

	@NotEmpty
	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;

	public Company getCompany() {
		return company;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + "]";
	}

}

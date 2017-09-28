package com.sajid.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ProductType implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="productType")
	private  Set<Product> products;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Product> getProducts() {
		return products;
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
		return "Company [id=" + id + "]";
	}

}

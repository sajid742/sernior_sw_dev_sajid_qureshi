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
public class Warehouse implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String location;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productSize")
	private Set<ProductSizeWarehouse> productSizeWarehouse;

	@NotEmpty
	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;

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

	public Set<ProductSizeWarehouse> getProductSizeWarehouse() {
		return productSizeWarehouse;
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

	public void setProductSizeWarehouse(Set<ProductSizeWarehouse> productSizeWarehouse) {
		this.productSizeWarehouse = productSizeWarehouse;
	}

	@Override
	public String toString() {
		return "Warehouse [id=" + id + "]";
	}

}

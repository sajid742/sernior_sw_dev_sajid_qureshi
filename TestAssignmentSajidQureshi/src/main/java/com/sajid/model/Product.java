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
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	private String name;
	
	//	@NotEmpty
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private ProductType productType;

	//	@NotEmpty
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private Brand brand;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private Set<ProductSize> productSizes;

	public Brand getBrand() {
		return brand;
	}

public Integer getId() {
		return id;
	}
	
public String getName() {
		return name;
	}
	
	public Set<ProductSize> getProductSizes() {
		return productSizes;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProductSizes(Set<ProductSize> productSizes) {
		this.productSizes = productSizes;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + "]";
	}

}

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
public class ProductSize implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	private String name;
	
	@NotEmpty
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;
	
	@NotEmpty
	@ManyToOne(fetch = FetchType.LAZY)
	private Size size;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productSize")
	private Set<ProductSizeWarehouse> productSizeWarehouse;

	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public Product getProduct() {
		return product;
	}

	public Set<ProductSizeWarehouse> getProductSizeWarehouse() {
		return productSizeWarehouse;
	}

	public Size getSize() {
		return size;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setProductSizeWarehouse(Set<ProductSizeWarehouse> productSizeWarehouse) {
		this.productSizeWarehouse = productSizeWarehouse;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + "]";
	}

}

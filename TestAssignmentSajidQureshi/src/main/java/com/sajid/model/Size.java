package com.sajid.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Size implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private Set<ProductSize> productSizes;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<ProductSize> getProductSizes() {
		return productSizes;
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

	@Override
	public String toString() {
		return "Size [id=" + id + "]";
	}

}

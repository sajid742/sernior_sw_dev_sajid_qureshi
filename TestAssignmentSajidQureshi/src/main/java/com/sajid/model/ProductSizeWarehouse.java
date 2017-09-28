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
public class ProductSizeWarehouse implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@ManyToOne
	(fetch = FetchType.LAZY)
	private ProductSize productSize;
	
	@NotEmpty
	@ManyToOne
	(fetch = FetchType.LAZY)
	private Warehouse warehouse;

	@NotEmpty
	private Integer inStock;

	private Integer availableQty;

	private Integer inTransit;

	@NotEmpty
	private Integer minOrderQty;
	
	@NotEmpty
	private Integer qtyPerBox;
	
	@NotEmpty
	private Integer reorderPoint;

	@NotEmpty
	private String name;

	public Integer getAvailableQty() {
		return availableQty;
	}

	public Integer getId() {
		return id;
	}

	public Integer getInStock() {
		return inStock;
	}

	public Integer getInTransit() {
		return inTransit;
	}

	public Integer getMinOrderQty() {
		return minOrderQty;
	}

	public String getName() {
		return name;
	}

	public ProductSize getProductSize() {
		return productSize;
	}

	public Integer getQtyPerBox() {
		return qtyPerBox;
	}

	public Integer getReorderPoint() {
		return reorderPoint;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setAvailableQty(Integer availableQty) {
		this.availableQty = availableQty;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInStock(Integer inStock) {
		this.inStock = inStock;
	}

	public void setInTransit(Integer inTransit) {
		this.inTransit = inTransit;
	}
	
	public void setMinOrderQty(Integer minOrderQty) {
		this.minOrderQty = minOrderQty;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setProductSize(ProductSize productSize) {
		this.productSize = productSize;
	}

	public void setQtyPerBox(Integer qtyPerBox) {
		this.qtyPerBox = qtyPerBox;
	}
	
	public void setReorderPoint(Integer reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public String toString() {
		return "Product Size Warehouse [id=" + id + "]";
	}

}

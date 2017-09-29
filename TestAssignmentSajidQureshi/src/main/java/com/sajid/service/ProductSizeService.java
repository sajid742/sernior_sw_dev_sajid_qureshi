package com.sajid.service;

import java.util.List;

import com.sajid.model.ProductSize;

public interface ProductSizeService {

	ProductSize findById(int id);

	void saveProductSize(ProductSize productSize);

	void updateProductSize(ProductSize productSize);
	
	void deleteProductSize(int id);

	List<ProductSize> findAllProductSizes();

}
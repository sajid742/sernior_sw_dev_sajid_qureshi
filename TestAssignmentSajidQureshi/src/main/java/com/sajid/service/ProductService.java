package com.sajid.service;

import java.util.List;

import com.sajid.model.Product;

public interface ProductService {

	Product findById(int id);

	void saveProduct(Product product);

	void updateProduct(Product product);
	
	void deleteProduct(int id);

	List<Product> findAllProducts();

}
package com.sajid.service;

import java.util.List;

import com.sajid.model.ProductType;

public interface ProductTypeService {

	ProductType findById(int id);

	void saveProductType(ProductType product);

	void updateProductType(ProductType product);
	
	void deleteProductType(int id);

	List<ProductType> findAllProductTypes();

}
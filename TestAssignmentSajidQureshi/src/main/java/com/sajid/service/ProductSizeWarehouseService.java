package com.sajid.service;

import java.util.List;

import com.sajid.model.ProductSizeWarehouse;

public interface ProductSizeWarehouseService {

	ProductSizeWarehouse findById(int id);

	void saveProductSizeWarehouse(ProductSizeWarehouse productSizeWarehouse);

	void updateProductSizeWarehouse(ProductSizeWarehouse productSizeWarehouse);
	
	void deleteProductSizeWarehouse(int id);

	List<ProductSizeWarehouse> findAllProductSizeWarehouses();

}
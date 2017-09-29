package com.sajid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sajid.dao.ProductSizeWarehouseDao;
import com.sajid.model.ProductSizeWarehouse;

@Service("productSizeWarehouseService")
@Transactional
public class ProductSizeWarehouseServiceImpl implements ProductSizeWarehouseService {

	@Autowired
	private ProductSizeWarehouseDao productSizeWarehouseDao;

	public ProductSizeWarehouse findById(int id) {
		return productSizeWarehouseDao.findById(id);
	}

	public void saveProductSizeWarehouse(ProductSizeWarehouse productSizeWarehouse) {
		productSizeWarehouseDao.save(productSizeWarehouse);
	}

	public List<ProductSizeWarehouse> findAllProductSizeWarehouses() {
		return productSizeWarehouseDao.findAll();
	}

	@Override
	public void updateProductSizeWarehouse(ProductSizeWarehouse productSizeWarehouse) {
		productSizeWarehouseDao.update(productSizeWarehouse);
	}

	@Override
	public void deleteProductSizeWarehouse(int id) {
		// TODO Auto-generated method stub
		
	}

}

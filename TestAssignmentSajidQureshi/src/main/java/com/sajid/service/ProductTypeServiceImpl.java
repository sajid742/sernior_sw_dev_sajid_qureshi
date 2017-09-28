package com.sajid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sajid.dao.ProductTypeDao;
import com.sajid.model.ProductType;

@Service("productTypeService")
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeDao productTypeDao;

	public ProductType findById(int id) {
		return productTypeDao.findById(id);
	}

	public void saveProductType(ProductType productType) {
		productTypeDao.save(productType);
	}

	public List<ProductType> findAllProductTypes() {
		return productTypeDao.findAll();
	}

	@Override
	public void updateProductType(ProductType productType) {
		productTypeDao.update(productType);
	}

	@Override
	public void deleteProductType(int id) {
		// TODO Auto-generated method stub
		
	}

}

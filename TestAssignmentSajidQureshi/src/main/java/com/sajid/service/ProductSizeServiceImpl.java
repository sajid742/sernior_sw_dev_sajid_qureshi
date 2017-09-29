package com.sajid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sajid.dao.ProductSizeDao;
import com.sajid.model.ProductSize;

@Service("productSizeService")
@Transactional
public class ProductSizeServiceImpl implements ProductSizeService {

	@Autowired
	private ProductSizeDao productSizeDao;

	public ProductSize findById(int id) {
		return productSizeDao.findById(id);
	}

	public void saveProductSize(ProductSize productSize) {
		productSizeDao.save(productSize);
	}

	public List<ProductSize> findAllProductSizes() {
		return productSizeDao.findAll();
	}

	@Override
	public void updateProductSize(ProductSize productSize) {
		productSizeDao.update(productSize);
	}

	@Override
	public void deleteProductSize(int id) {
		// TODO Auto-generated method stub
		
	}

}

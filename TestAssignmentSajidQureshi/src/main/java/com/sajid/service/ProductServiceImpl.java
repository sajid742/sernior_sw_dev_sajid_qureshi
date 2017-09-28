package com.sajid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sajid.dao.ProductDao;
import com.sajid.model.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	public Product findById(int id) {
		return productDao.findById(id);
	}

	public void saveProduct(Product product) {
		productDao.save(product);
	}

	public List<Product> findAllProducts() {
		return productDao.findAll();
	}

	@Override
	public void updateProduct(Product product) {
		productDao.update(product);
	}

	@Override
	public void deleteProduct(int id) {
		productDao.delete(productDao.findById(id));
		
	}

}

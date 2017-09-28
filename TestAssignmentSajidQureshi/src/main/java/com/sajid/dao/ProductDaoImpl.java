package com.sajid.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sajid.model.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDaoImpl<Integer, Product> implements ProductDao {
	
}

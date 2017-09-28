package com.sajid.dao;

import org.springframework.stereotype.Repository;

import com.sajid.model.ProductType;

@Repository("productTypeDao")
public class ProductTypeDaoImpl extends AbstractDaoImpl<Integer, ProductType> implements ProductTypeDao {
	
}

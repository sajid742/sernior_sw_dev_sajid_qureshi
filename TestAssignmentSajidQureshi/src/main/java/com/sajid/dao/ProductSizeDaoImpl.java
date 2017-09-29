package com.sajid.dao;

import org.springframework.stereotype.Repository;

import com.sajid.model.ProductSize;

@Repository("productSizeDao")
public class ProductSizeDaoImpl extends AbstractDaoImpl<Integer, ProductSize> implements ProductSizeDao {
	
}

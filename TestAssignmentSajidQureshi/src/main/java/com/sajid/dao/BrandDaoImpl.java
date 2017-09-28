package com.sajid.dao;

import org.springframework.stereotype.Repository;

import com.sajid.model.Brand;

@Repository("brandDao")
public class BrandDaoImpl extends AbstractDaoImpl<Integer, Brand> implements BrandDao {
	
}

package com.sajid.dao;

import org.springframework.stereotype.Repository;

import com.sajid.model.ProductSizeWarehouse;

@Repository("productSizeWarehouseDao")
public class ProductSizeWarehouseDaoImpl extends AbstractDaoImpl<Integer, ProductSizeWarehouse> implements ProductSizeWarehouseDao {
	
}

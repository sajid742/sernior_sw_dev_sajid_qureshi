package com.sajid.dao;

import org.springframework.stereotype.Repository;

import com.sajid.model.Warehouse;

@Repository("warehouseDao")
public class WarehouseDaoImpl extends AbstractDaoImpl<Integer, Warehouse> implements WarehouseDao {
	
}

package com.sajid.service;

import java.util.List;

import com.sajid.model.Warehouse;

public interface WarehouseService {

	Warehouse findById(int id);

	void saveWarehouse(Warehouse warehouse);

	void updateWarehouse(Warehouse warehouse);
	
	void deleteWarehouse(int id);

	List<Warehouse> findAllWarehouses();

}
package com.sajid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sajid.dao.WarehouseDao;
import com.sajid.model.Warehouse;

@Service("warehouseService")
@Transactional
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	private WarehouseDao warehouseDao;

	public Warehouse findById(int id) {
		return warehouseDao.findById(id);
	}

	public void saveWarehouse(Warehouse warehouse) {
		warehouseDao.save(warehouse);
	}

	public List<Warehouse> findAllWarehouses() {
		return warehouseDao.findAll();
	}

	@Override
	public void updateWarehouse(Warehouse warehouse) {
		warehouseDao.update(warehouse);
	}

	@Override
	public void deleteWarehouse(int id) {
		// TODO Auto-generated method stub
		
	}

}

package com.sajid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sajid.dao.BrandDao;
import com.sajid.model.Brand;

@Service("brandService")
@Transactional
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;

	public Brand findById(int id) {
		return brandDao.findById(id);
	}

	public void saveBrand(Brand brand) {
		brandDao.save(brand);
	}

	public List<Brand> findAllBrands() {
		return brandDao.findAll();
	}

	@Override
	public void updateBrand(Brand brand) {
		brandDao.update(brand);
	}

	@Override
	public void deleteBrand(int id) {
		// TODO Auto-generated method stub
		
	}

}

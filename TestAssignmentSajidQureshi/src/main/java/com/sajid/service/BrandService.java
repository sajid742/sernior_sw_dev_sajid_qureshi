package com.sajid.service;

import java.util.List;

import com.sajid.model.Brand;

public interface BrandService {

	Brand findById(int id);

	void saveBrand(Brand brand);

	void updateBrand(Brand brand);
	
	void deleteBrand(int id);

	List<Brand> findAllBrands();

}
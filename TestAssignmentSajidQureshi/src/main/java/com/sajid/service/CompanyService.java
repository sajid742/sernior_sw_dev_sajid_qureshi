package com.sajid.service;

import java.util.List;

import com.sajid.model.Company;

public interface CompanyService {

	Company findById(int id);

	void saveCompany(Company company);

	void updateCompany(Company company);
	
	void deleteCompany(int id);

	List<Company> findAllCompanys();

}
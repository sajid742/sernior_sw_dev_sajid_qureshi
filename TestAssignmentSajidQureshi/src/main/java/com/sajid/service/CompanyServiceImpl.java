package com.sajid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sajid.dao.CompanyDao;
import com.sajid.model.Company;

@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	public Company findById(int id) {
		return companyDao.findById(id);
	}

	public void saveCompany(Company company) {
		companyDao.save(company);
	}

	public List<Company> findAllCompanys() {
		return companyDao.findAll();
	}

	@Override
	public void updateCompany(Company company) {
		companyDao.update(company);
	}

	@Override
	public void deleteCompany(int id) {
		// TODO Auto-generated method stub
		
	}

}

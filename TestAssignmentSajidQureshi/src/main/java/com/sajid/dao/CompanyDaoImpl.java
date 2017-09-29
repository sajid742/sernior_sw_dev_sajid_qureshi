package com.sajid.dao;

import org.springframework.stereotype.Repository;

import com.sajid.model.Company;

@Repository("companyDao")
public class CompanyDaoImpl extends AbstractDaoImpl<Integer, Company> implements CompanyDao {
	
}

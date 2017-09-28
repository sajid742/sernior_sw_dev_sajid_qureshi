package com.sajid.dao;

import java.util.List;

import com.sajid.model.Brand;

public interface AbstractDao <T>{

	T findById(int id);

	void save(T t);
	
	void update(T t);
	
	void delete(T t);

	List<T> findAll();

}

package com.sajid.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sajid.model.Brand;
import com.sajid.service.BrandService;

/**
 * A converter class used in views to map id's to actual brand objects.
 */
@Component
public class StringToBrandConverter implements Converter<Object, Brand>{

	@Autowired
	BrandService brandService;

	/**
	 * Gets Brand by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public Brand convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Brand brand= brandService.findById(id);
		System.out.println("product type : "+brand);
		return brand;
	}
	
}
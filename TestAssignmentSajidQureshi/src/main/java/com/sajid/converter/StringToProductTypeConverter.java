package com.sajid.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sajid.model.ProductType;
import com.sajid.service.ProductTypeService;

/**
 * A converter class used in views to map id's to actual productType objects.
 */
@Component
public class StringToProductTypeConverter implements Converter<Object, ProductType>{

	@Autowired
	ProductTypeService productTypeService;

	/**
	 * Gets ProductType by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public ProductType convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		ProductType productType= productTypeService.findById(id);
		System.out.println("product type : "+productType);
		return productType;
	}
	
}
package com.sajid.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.validation.constraints.AssertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sajid.configuration.AppConfig;
import com.sajid.model.Product;
import com.sajid.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = AppConfig.class)
//@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class JUnitProductService {

	@Autowired
	private ProductService productService;

	@BeforeClass
	public static void setUp() {
		System.out.println("-----> SETUP <-----");
	}

	@Test
	public void testProductService() {
		assertEquals("class com.sajid.service.ProductServiceImpl", this.productService.getClass().toString());
	}

	@Test
	public void testProductServiceSaveProduct() {
		//	add product test
		Product product = new Product();
		product.setName("test name");
		productService.saveProduct(product);
		boolean result = productService.findAllProducts().contains(product);
		assertEquals(true, result);		
	}

	@AfterClass
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
}

package com.sajid.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sajid.model.Product;
import com.sajid.service.BrandService;
import com.sajid.service.ProductService;
import com.sajid.service.ProductTypeService;



@Controller
@RequestMapping("/Product")
@SessionAttributes("roles")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	BrandService brandService;
	
	@Autowired
	ProductTypeService productTypeService;	
	
	@Autowired
	MessageSource messageSource;

	/**
	 * This method will list all existing products.
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listProducts(ModelMap model) {

		List<Product> products = productService.findAllProducts();
		model.addAttribute("products", products);
		return "productslist";
	}

	/**
	 * This method will provide the medium to add a new product.
	 */
	@RequestMapping(value = { "/newproduct" }, method = RequestMethod.GET)
	public String newProduct(ModelMap model) {
		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("productTypes", productTypeService.findAllProductTypes());
		model.addAttribute("brands", brandService.findAllBrands());
		model.addAttribute("edit", false);
		return "newproduct";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving product in database. It also validates the product input
	 */
	@RequestMapping(value = { "/newproduct" }, method = RequestMethod.POST)
	public String saveProduct(@Valid Product product, BindingResult result,
			ModelMap model) {

//		if (result.hasErrors()) {
//			return "productslist";
//		}
		
		model.addAttribute("productTypes", productTypeService.findAllProductTypes());
		model.addAttribute("brand", brandService.findAllBrands());
		model.addAttribute("edit", true);
		productService.saveProduct(product);

		return "newproduct";
	}



	/**
	 * This method will be called on form submission, handling POST request for
	 * updating product in database. It also validates the product input
	 */
	@RequestMapping(value = { "/edit-product-{id}" }, method = RequestMethod.POST)
	public String updateProduct(@Valid Product product, BindingResult result,
			ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			return "registration";
		}

		productService.updateProduct(product);

		model.addAttribute("success", "Product " + product.getName() + " "+ product.getId() + " updated successfully");
		return "registrationsuccess";
	}
	
	@RequestMapping(value = { "/edit-product-{id}" }, method = RequestMethod.GET)
	@Transactional
	public String editProduct(@Valid Product product, BindingResult result,
			ModelMap model, @PathVariable int id) {
		Product prodcut = productService.findById(id);
		model.addAttribute("product", prodcut);
		model.addAttribute("productTypes", productTypeService.findAllProductTypes());
		model.addAttribute("brands", brandService.findAllBrands());
		model.addAttribute("edit", true);
		return "newproduct";		
	}
	
	
	@RequestMapping(value = { "/delete-product-{id}" }, method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") int id) {
		productService.deleteProduct(id);
		return "redirect:/Product/list";
	}

}

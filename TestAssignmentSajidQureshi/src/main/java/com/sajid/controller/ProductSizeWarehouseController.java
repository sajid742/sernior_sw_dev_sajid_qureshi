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

import com.sajid.model.ProductSizeWarehouse;
import com.sajid.service.BrandService;
import com.sajid.service.ProductSizeWarehouseService;

@Controller
@RequestMapping("/ProductSizeWarehouse")
@SessionAttributes("roles")
public class ProductSizeWarehouseController {

	@Autowired
	ProductSizeWarehouseService productSizeWarehouseService;

	@Autowired
	BrandService brandService;

	@Autowired
	MessageSource messageSource;

	/**
	 * This method will list all existing productSizeWarehouses.
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listProductSizeWarehouses(ModelMap model) {
		List<ProductSizeWarehouse> productSizeWarehouses = productSizeWarehouseService.findAllProductSizeWarehouses();
		model.addAttribute("productSizeWarehouses", productSizeWarehouses);
		return "productSizeWarehouseslist";
	}

	/**
	 * This method will provide the medium to add a new productSizeWarehouse.
	 */
	@RequestMapping(value = { "/newproductSizeWarehouse" }, method = RequestMethod.GET)
	public String newProductSizeWarehouse(ModelMap model) {
		ProductSizeWarehouse productSizeWarehouse = new ProductSizeWarehouse();
		model.addAttribute("productSizeWarehouse", productSizeWarehouse);
		model.addAttribute("brands", brandService.findAllBrands());
		model.addAttribute("edit", false);
		return "newproductSizeWarehouse";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving productSizeWarehouse in database. It also validates the
	 * productSizeWarehouse input
	 */
	@RequestMapping(value = { "/newproductSizeWarehouse" }, method = RequestMethod.POST)
	public String saveProductSizeWarehouse(@Valid ProductSizeWarehouse productSizeWarehouse, BindingResult result,
			ModelMap model) {

		// if (result.hasErrors()) {
		// return "productSizeWarehouseslist";
		// }

		model.addAttribute("brand", brandService.findAllBrands());
		model.addAttribute("edit", true);
		productSizeWarehouseService.saveProductSizeWarehouse(productSizeWarehouse);

		return "newproductSizeWarehouse";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating productSizeWarehouse in database. It also validates the
	 * productSizeWarehouse input
	 */
	@RequestMapping(value = { "/edit-productSizeWarehouse-{id}" }, method = RequestMethod.POST)
	public String updateProductSizeWarehouse(@Valid ProductSizeWarehouse productSizeWarehouse, BindingResult result,
			ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			return "registration";
		}

		productSizeWarehouseService.updateProductSizeWarehouse(productSizeWarehouse);

		model.addAttribute("success", "ProductSizeWarehouse " + productSizeWarehouse.getId() + " "
				+ productSizeWarehouse.getId() + " updated successfully");
		return "registrationsuccess";
	}

	@RequestMapping(value = { "/edit-productSizeWarehouse-{id}" }, method = RequestMethod.GET)
	@Transactional
	public String editProductSizeWarehouse(@Valid ProductSizeWarehouse productSizeWarehouse, BindingResult result,
			ModelMap model, @PathVariable int id) {
		ProductSizeWarehouse prodcut = productSizeWarehouseService.findById(id);
		model.addAttribute("productSizeWarehouse", prodcut);
		model.addAttribute("brands", brandService.findAllBrands());
		model.addAttribute("edit", true);
		return "newproductSizeWarehouse";
	}

	@RequestMapping(value = { "/delete-productSizeWarehouse-{id}" }, method = RequestMethod.GET)
	public String deleteProductSizeWarehouse(@PathVariable("id") int id) {
		productSizeWarehouseService.deleteProductSizeWarehouse(id);
		return "redirect:/ProductSizeWarehouse/list";
	}

}

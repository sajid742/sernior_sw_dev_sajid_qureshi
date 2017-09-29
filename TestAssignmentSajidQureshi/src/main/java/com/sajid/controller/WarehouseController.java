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

import com.sajid.model.Warehouse;
import com.sajid.service.CompanyService;
import com.sajid.service.WarehouseService;



@Controller
@RequestMapping("/Warehouse")
@SessionAttributes("roles")
public class WarehouseController {

	@Autowired
	WarehouseService warehouseService;
	
	@Autowired
	CompanyService companyService;
	
	
	@Autowired
	MessageSource messageSource;

	/**
	 * This method will list all existing warehouses.
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listWarehouses(ModelMap model) {

		List<Warehouse> warehouses = warehouseService.findAllWarehouses();
		model.addAttribute("warehouses", warehouses);
		return "warehouseslist";
	}

	/**
	 * This method will provide the medium to add a new warehouse.
	 */
	@RequestMapping(value = { "/newwarehouse" }, method = RequestMethod.GET)
	public String newWarehouse(ModelMap model) {
		Warehouse warehouse = new Warehouse();
		model.addAttribute("warehouse", warehouse);
		model.addAttribute("companies", companyService.findAllCompanys());
		model.addAttribute("edit", false);
		return "newwarehouse";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving warehouse in database. It also validates the warehouse input
	 */
	@RequestMapping(value = { "/newwarehouse" }, method = RequestMethod.POST)
	public String saveWarehouse(@Valid Warehouse warehouse, BindingResult result,
			ModelMap model) {

//		if (result.hasErrors()) {
//			return "warehouseslist";
//		}
		
		model.addAttribute("company", companyService.findAllCompanys());
		model.addAttribute("edit", true);
		warehouseService.saveWarehouse(warehouse);

		return "newwarehouse";
	}



	/**
	 * This method will be called on form submission, handling POST request for
	 * updating warehouse in database. It also validates the warehouse input
	 */
	@RequestMapping(value = { "/edit-warehouse-{id}" }, method = RequestMethod.POST)
	public String updateWarehouse(@Valid Warehouse warehouse, BindingResult result,
			ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			return "registration";
		}

		warehouseService.updateWarehouse(warehouse);

		model.addAttribute("success", "Warehouse " + warehouse.getName() + " "+ warehouse.getId() + " updated successfully");
		return "registrationsuccess";
	}
	
	@RequestMapping(value = { "/edit-warehouse-{id}" }, method = RequestMethod.GET)
	@Transactional
	public String editWarehouse(@Valid Warehouse warehouse, BindingResult result,
			ModelMap model, @PathVariable int id) {
		Warehouse prodcut = warehouseService.findById(id);
		model.addAttribute("warehouse", prodcut);
		model.addAttribute("company", companyService.findAllCompanys());
		model.addAttribute("edit", true);
		return "newwarehouse";		
	}
	
	
	@RequestMapping(value = { "/delete-warehouse-{id}" }, method = RequestMethod.GET)
	public String deleteWarehouse(@PathVariable("id") int id) {
		warehouseService.deleteWarehouse(id);
		return "redirect:/Warehouse/list";
	}

}

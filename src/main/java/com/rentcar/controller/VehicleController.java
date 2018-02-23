package com.rentcar.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rentcar.entity.Product;
import com.rentcar.entity.Vehicle;
import com.rentcar.service.ProductServiceImpl;
import com.rentcar.service.VehicleServiceImpl;

@Controller
public class VehicleController {
	@Autowired
	VehicleServiceImpl vehicleService;
	
	@Autowired
	ProductServiceImpl productService;
	
	@GetMapping("/vehicle/list")
	public ModelAndView vehicleListPage(){
		ModelAndView modelAndView = new ModelAndView();
		List<Vehicle> vehicles = vehicleService.getAllVehicles();
		modelAndView.addObject("vehicles", vehicles);
		modelAndView.setViewName("vehicle/list");
		return modelAndView;
	}
	
	@GetMapping("vehicle/add")
	public ModelAndView addVehiclePage(){
		ModelAndView modelAndView = new ModelAndView();
		Vehicle vehicle = new Vehicle();
		List<Product> products = productService.getAllProducts();
		modelAndView.addObject("vehicle", vehicle);
		modelAndView.addObject("products", products);
		modelAndView.setViewName("vehicle/add");
		return modelAndView;
	}
	
	@PostMapping("vehicle/add")
	public ModelAndView addVehicle(@Valid Vehicle vehicle, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
			Product product = vehicle.getProduct();
			if(product.getId() == null){
				vehicleService.addVehicle(vehicle, product);
			}else{
				vehicle.setProduct(productService.getProductById(vehicle.getProduct().getId()));
				vehicleService.addVehicle(vehicle);
			}
			
			modelAndView.setViewName("redirect:/vehicle/list");
		return modelAndView;
	}
	
	@GetMapping("vehicle/delete/{id}")
	public ModelAndView deleteVehicle(@PathVariable("id") Long id){
		ModelAndView modelAndView = new ModelAndView();
		vehicleService.deleteVehicle(id);
		modelAndView.setViewName("redirect:/vehicle/list");
		return modelAndView;
	}
	
	@GetMapping("vehicle/edit/{id}")
	public ModelAndView editVehicle(@PathVariable("id") Long id){
		ModelAndView modelAndView = new ModelAndView();
		Vehicle v = vehicleService.getVehicleById(id);
		List<Product> products = productService.getAllProducts();
		modelAndView.addObject("products", products);
		modelAndView.addObject("vehicle", v);
		modelAndView.setViewName("vehicle/edit");
		return modelAndView;
	}
	
	@PostMapping("vehicle/edit")
	public ModelAndView updateVehicle(@Valid Vehicle vehicle, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		Product product = vehicle.getProduct();

			if(vehicle.getProduct().getId() == null){
				vehicleService.updateVehicle(vehicle, product);
			}else{
				vehicleService.updateVehicle(vehicle);
			}
			modelAndView.setViewName("redirect:/vehicle/list");

		return modelAndView;
	}
}

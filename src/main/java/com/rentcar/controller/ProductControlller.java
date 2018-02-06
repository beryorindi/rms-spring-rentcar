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

import com.rentcar.entity.Car;
import com.rentcar.entity.Product;
import com.rentcar.service.CarServiceImpl;
import com.rentcar.service.ProductServiceImpl;

@Controller
public class ProductControlller {
	@Autowired
	ProductServiceImpl productService;
	
	@Autowired
	CarServiceImpl carService;
	
	@GetMapping("**/products")
	public ModelAndView productsPage(){
		ModelAndView modelAndView = new ModelAndView();
		List<Product> products = productService.getAllProducts();
		modelAndView.addObject("products", products);
		modelAndView.setViewName("product/products");
		return modelAndView;
	}
	
	@GetMapping("products/add")
	/*@GetMapping({"/admin/cars/add","/super_admin/cars/add"})*/
	public ModelAndView addProductPage(){
		ModelAndView modelAndView = new ModelAndView();
		Product product = new Product();
		List<Car> cars = carService.getAllCars();
		modelAndView.addObject("product", product);
		modelAndView.addObject("cars", cars);
		modelAndView.setViewName("product/add");
		return modelAndView;
	}
	
	@PostMapping("products/add")
	/*	@PostMapping({"/admin/cars/add","/super_admin/cars/add"})*/
		public ModelAndView addProduct(@Valid Product product, BindingResult bindingResult){
			ModelAndView modelAndView = new ModelAndView();
			/*if (bindingResult.hasErrors()) {
				modelAndView.setViewName("product/add");
			} else {*/
			Car car = carService.getCarById(product.getCar().getId());
			product.setCar(car);
			
			productService.addProduct(product);
			
			//modelAndView.addObject("successMessage", "Car has been added successfully");
			List<Product> products = productService.getAllProducts();
			modelAndView.addObject("products", products);
			modelAndView.setViewName("redirect:/products");
//			}
			return modelAndView;
		}
	
	@GetMapping("products/delete/{id}")
	/*@GetMapping({"/admin/cars/add","/super_admin/cars/add"})*/
	public ModelAndView deleteProduct(@PathVariable("id") Long id){
		ModelAndView modelAndView = new ModelAndView();
		productService.deleteProduct(id);
		//modelAndView.addObject("successMessage", "Car has been added successfully");
		List<Product> products = productService.getAllProducts();
		modelAndView.addObject("products", products);
		modelAndView.setViewName("redirect:/products");
		return modelAndView;
	}
	
	@GetMapping("products/edit/{id}")
	/*@GetMapping({"/admin/cars/add","/super_admin/cars/add"})*/
	public ModelAndView updateProductPage(@PathVariable("id") Long id){
		ModelAndView modelAndView = new ModelAndView();
		Product product = productService.getProductById(id);
		List<Car> cars = carService.getAllCars();
		modelAndView.addObject("product", product);
		modelAndView.addObject("cars", cars);
		modelAndView.setViewName("product/edit");
		return modelAndView;
	}
	
	@PostMapping("products/edit")
	/*@GetMapping({"/admin/products/add","/super_admin/products/add"})*/
	public ModelAndView updateProduct(@Valid Product product, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("products/edit");
		} else {
		Car car = carService.getCarById(product.getCar().getId());
		product.setCar(car);
		product.setAvailable(product.getStock());
		productService.updateProduct(product);
		//modelAndView.addObject("successMessage", "product has been added successfully");
		List<Product> products = productService.getAllProducts();
		modelAndView.addObject("products", products);
		modelAndView.setViewName("redirect:/products");
		}
		return modelAndView;
	}
}

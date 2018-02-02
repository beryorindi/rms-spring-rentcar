package com.rentcar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import com.rentcar.entity.Product;
import com.rentcar.service.ProductServiceImpl;

@Controller
public class ProductControlller {
	@Autowired
	ProductServiceImpl productService;
	
	@GetMapping("**/products")
	public ModelAndView productsPage(){
		ModelAndView modelAndView = new ModelAndView();
		List<Product> products = productService.getAllProducts();
		modelAndView.addObject("products", products);
		modelAndView.setViewName("product/products");
		return modelAndView;
	}
}

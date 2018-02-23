package com.rentcar.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rentcar.entity.Product;
import com.rentcar.service.ProductServiceImpl;
import com.rentcar.service.VehicleServiceImpl;

@Controller
public class ProductControlller {
	@Autowired
	ProductServiceImpl productService;
	
	@Autowired
	VehicleServiceImpl vehicleService;
	
	public String getRole(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = null;
		if (auth.getPrincipal() instanceof UserDetails) {
			role = auth.getAuthorities().toString().toLowerCase();
			role = role.substring(1, role.length()-1);
		}
		return role;
	}
	
	@GetMapping("/product/list")
	public ModelAndView productsListPage(){
		ModelAndView modelAndView = new ModelAndView();
		List<Product> products = productService.getAllProducts();
		modelAndView.addObject("products", products);
		modelAndView.setViewName("product/list");
		return modelAndView;
	}
	
	@GetMapping("product/delete/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") Long id){
		ModelAndView modelAndView = new ModelAndView();
		productService.deleteProduct(id);
		List<Product> products = productService.getAllProducts();
		modelAndView.addObject("products", products);
		modelAndView.setViewName("redirect:/products/list");
		return modelAndView;
	}
	
	@GetMapping("product/edit/{id}")
	public ModelAndView updateProductPage(@PathVariable("id") Long id){
		ModelAndView modelAndView = new ModelAndView();
		Product product = productService.getProductById(id);
		modelAndView.addObject("product", product);
		modelAndView.setViewName("product/edit");
		return modelAndView;
	}
	
	@PostMapping("product/edit")
	@GetMapping({"/admin/products/add","/super_admin/products/add"})
	public ModelAndView updateProduct(@Valid Product product, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		productService.updateProduct(product);
		modelAndView.setViewName("redirect:/product/list");
		return modelAndView;
	}
	
	
}

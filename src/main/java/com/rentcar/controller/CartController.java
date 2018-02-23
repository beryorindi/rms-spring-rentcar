package com.rentcar.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.rentcar.entity.Product;
import com.rentcar.model.Cart;
import com.rentcar.model.CartItem;
import com.rentcar.service.ProductService;
import com.rentcar.service.ProductServiceImpl;

@Controller
@Scope("request")
public class CartController {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private Cart cart;
	
	@GetMapping("/cart")
	public ModelAndView cartPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("cart", this.cart);
		modelAndView.setViewName("cart/cart");
		return modelAndView;
	}
	
	@GetMapping("/cart/add/{id}")
	public ModelAndView addToCart(@PathVariable("id") Long id){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Product product = productService.getProductById(id);
		
		CartItem cartItem = new CartItem();
		cartItem.setId(UUID.randomUUID());
		cartItem.setProduct(product);
		cartItem.setItemNum(1);
		cartItem.setItemPrice(product.getPrice(), cartItem.getItemNum());
		
		cart.setOrderNum(sdf.format(timestamp));
		cart.setCustomerInfo(auth.getName());
		cart.addCartItem(cartItem);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/cart");
		return modelAndView;
	}
}

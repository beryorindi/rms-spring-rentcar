package com.rentcar.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentcar.entity.Product;
import com.rentcar.model.CartItem;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private VehicleServiceImpl vehicleService;
		
	@Override
	public CartItem addCartItem(Long id) {
		Product product = productService.getProductById(id);
		CartItem cartItem = new CartItem();
		cartItem.setId(UUID.randomUUID());
		cartItem.setProduct(product);
		cartItem.setItemNum(1);
		cartItem.setItemPrice(product.getPrice(), cartItem.getItemNum());
		cartItem.setVehicles(vehicleService.getVehiclesById(product.getId()));
		return cartItem;
	}
	
}

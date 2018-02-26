package com.rentcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.rentcar.entity.Product;
import com.rentcar.entity.Vehicle;
import com.rentcar.model.Cart;
import com.rentcar.model.CartItem;

@Scope("session")
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private VehicleServiceImpl vehicleService;
	
	@Autowired
	private Cart cart;
		
	@Override
	public CartItem addCartItem(Long productId) {
		Product product = productService.getProductById(productId);
		CartItem cartItem = new CartItem();
		cartItem.setId(UUID.randomUUID());
		cartItem.setProduct(product);
		cartItem.setItemNum(1);
		cartItem.setItemPrice(product.getPrice(), cartItem.getItemNum());
		cartItem.setVehicles(new ArrayList<Vehicle>());
		cartItem.setVehicles(vehicleService.getRandomVehicleByProductId(productId));
		return cartItem;
	}

	@Override
	public void editCartItem(UUID id, CartItem newCartItem) {
		for(int i=0; i< getAllCartItems().size(); i++){
			if(getCartItemByIndex(i).getId().equals(id)){
				getCartItemByIndex(i).setItemNum(newCartItem.getItemNum());
				getCartItemByIndex(i).setItemPrice(newCartItem.getProduct().getPrice(), newCartItem.getItemNum());
				getCartItemByIndex(i).setProduct(newCartItem.getProduct());
				getCartItemByIndex(i).setVehicles(newCartItem.getVehicles());
			}
		}
	}

	@Override
	public void deleteCartItem(UUID id) {
		for(int i=0; i< getAllCartItems().size(); i++){
			if(getCartItemByIndex(i).getId().equals(id)){
				this.cart.removeCartItem(i);
			}
		}
	}

	@Override
	public List<CartItem> getAllCartItems() {
		return this.cart.getCartItems();
	}

	@Override
	public CartItem getCartItemByIndex(int index) {
		return getAllCartItems().get(index);
	}
	
}

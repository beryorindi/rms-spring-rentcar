package com.rentcar.service;



import java.util.List;
import java.util.UUID;

import com.rentcar.model.CartItem;

public interface CartService {
	CartItem addCartItem(Long productId);
	void editCartItem(UUID id, CartItem newCartItem);
	void deleteCartItem(UUID id);
	List<CartItem> getAllCartItems();
	CartItem getCartItemByIndex(int index);
}

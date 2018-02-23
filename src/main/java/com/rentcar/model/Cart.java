package com.rentcar.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Cart {
	
	private String orderNum;
	
	private String customerInfo;
	
	private List<CartItem> cartItems = new ArrayList<CartItem>();

	private int totalPrice;
	
	public Cart() {
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(String customerInfo) {
		this.customerInfo = customerInfo;
	}
	
	
	
	/*public boolean isEmpty(){
		boolean result;
		if(!this.cartItems.isEmpty()){
			result = false;
		}
		else{
			result = true;
		}
		return result;
	}*/
	
	public void addCartItem(CartItem cartItem){
		this.cartItems.add(cartItem);
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}

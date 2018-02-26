package com.rentcar.model;

import java.util.List;
import java.util.UUID;

import com.rentcar.entity.Product;
import com.rentcar.entity.Vehicle;


public class CartItem {
	
	private UUID id;
	
	private Product product;
	
	private List<Vehicle> vehicles;
	
	private int itemNum;
	
	private int itemPrice;

	public CartItem() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public void setItemPrice(int price, int num) {
		this.itemPrice = price * num;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public void setVehicles(Vehicle vehicle){
		this.vehicles.add(vehicle);
	}
	
}

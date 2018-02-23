package com.rentcar.model;

import java.util.Date;

import com.rentcar.entity.Product;


public class OrderDetail {
	
	private Long id;
	private int quantity;
	private Product product;
	private Order order;
	private int dayNumRent;
	private Date startDateRent;

	public OrderDetail() {
	}

	public OrderDetail(Long id, int quantity, Product product, Order order, int dayNumRent, Date startDateRent) {
		this.id = id;
		this.quantity = quantity;
		this.product = product;
		this.order = order;
		this.dayNumRent = dayNumRent;
		this.startDateRent = startDateRent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getDayNumRent() {
		return dayNumRent;
	}

	public void setDayNumRent(int dayNumRent) {
		this.dayNumRent = dayNumRent;
	}

	public Date getStartDateRent() {
		return startDateRent;
	}

	public void setStartDateRent(Date startDateRent) {
		this.startDateRent = startDateRent;
	}
	
	
}

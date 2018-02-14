package com.rentcar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
@Entity
@Table(name="order_detail")*/
public class OrderDetail {
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="quantity")
	private int quantity;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id", nullable= false)
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="order_id", nullable = false)
	private Order order;
	
	@Column(name="day_num_rent")
	private int dayNumRent;
	
	@Column(name="start_date_rent")
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
	
	*/
}

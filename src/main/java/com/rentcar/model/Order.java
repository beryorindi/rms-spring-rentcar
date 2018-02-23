package com.rentcar.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {

	private Long id;
	private String orderBy;
	private String status;
	private Date orderDate;	
	private Date updateOn;
	private Date updateBy;
	private Set<OrderDetail> orderDetails = new HashSet<>();
	
	public Order() {
	}

	public Order(Long id, String orderBy, String status, Date orderDate, Date updateOn, Date updateBy,
			Set<OrderDetail> orderDetails) {
		this.id = id;
		this.orderBy = orderBy;
		this.status = status;
		this.orderDate = orderDate;
		this.updateOn = updateOn;
		this.updateBy = updateBy;
		this.orderDetails = orderDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}

	public Date getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Date updateBy) {
		this.updateBy = updateBy;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
}

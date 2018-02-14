package com.rentcar.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/*
@Entity
@Table(name="order")*/
public class Order {
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="order_by")
	private String orderBy;
	
	@Column(name="status")
	private String status;
	
	@Column(name="order_date")
	private Date orderDate;	
	
	@Column(name="update_on")
	private Date updateOn;
	
	@Column(name="update_by")
	private Date updateBy;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order_detail")
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
	
	*/
}

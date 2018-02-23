package com.rentcar.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Scope("session")
@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_id")
	private Long id;
	
	@Column(name="stock")
	private int stock;
	
	@Column(name="name")
	private String name;
	
	@Column(name="available")
	private int available;
	
	@Column(name="price")
	private int price;
	
	@OneToMany(cascade = CascadeType.ALL, 
			mappedBy = "product")
	private List<Vehicle> vehicles;
	
	
/*	@OneToOne(cascade= CascadeType.ALL, mappedBy = "product", fetch =FetchType.LAZY)
	private OrderDetail orderDetail;*/

	public Product() {
	}

/*	public Product(Long id, int stock, int price, Car car) {
		this.id = id;
		this.stock = stock;
		this.price = price;
		this.car = car;
		this.available = stock;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
/*	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}*/

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

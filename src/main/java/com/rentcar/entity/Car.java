package com.rentcar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="cars")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="brand")
	@NotEmpty(message = "*Please input brand")
	private String brand;
	@Column(name="model")
	@NotEmpty(message = "*Please input model")
	private String model;
	@Column(name="type")
	@NotEmpty(message = "*Please input type")
	private String type;
	@Column(name="transmition")
	@NotEmpty(message = "*Please input transmition")
	private String transmition;
	@Column(name="seat")
	private int seat;
	@Column(name="year")
	private int year;

	public Car(){}
	
	public Car(String transmition, String type, String brand, int year, String model, int seat) {
		this.transmition = transmition;
		this.type = type;
		this.brand = brand;
		this.year = year;
		this.model = model;
		this.seat = seat;
	}
	
	
	public String getTransmition() {
		return transmition;
	}
	public void setTransmition(String transmition) {
		this.transmition = transmition;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}

	public Long getId() {
		return id;
	}
	
}

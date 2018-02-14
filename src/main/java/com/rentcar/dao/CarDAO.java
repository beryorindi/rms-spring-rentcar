package com.rentcar.dao;

import java.util.List;

import com.rentcar.entity.Car;

public interface CarDAO {
	List<Car> getAllCars();
	List<Car> getUnlikedCars();
	Car getCarById(Long id);
	void addCar(Car car);
	void updateCar(Car car);
	void deleteCar(Long id);
	boolean carExists(String brand, String model, String type);
}

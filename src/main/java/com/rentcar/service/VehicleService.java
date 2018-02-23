package com.rentcar.service;

import java.util.List;

import com.rentcar.entity.Product;
import com.rentcar.entity.Vehicle;


public interface VehicleService {
	List<Vehicle> getAllVehicles();
	List<Vehicle> getUnlinkedVehicles();
	Vehicle getVehicleById(Long id);
	void addVehicle(Vehicle vehicle);
	void addVehicle(Vehicle vehicle,Product product);
	void updateVehicle(Vehicle vehicle);
	void updateVehicle(Vehicle vehicle, Product product);
	void deleteVehicle(Long id);
	
}

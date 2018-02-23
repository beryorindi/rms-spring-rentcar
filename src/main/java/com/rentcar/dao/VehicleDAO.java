package com.rentcar.dao;

import java.util.List;

import com.rentcar.entity.Vehicle;

public interface VehicleDAO {
	List<Vehicle> getAllVehicles();
	List<Vehicle> getVehiclesById(Long id);
	Vehicle getVehicleById(Long id);
	void addVehicle(Vehicle vehicle);
	void updateVehicle(Vehicle Vehicle);
	void deleteVehicle(Vehicle vehicle);
}

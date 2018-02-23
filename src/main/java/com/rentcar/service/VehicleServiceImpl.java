package com.rentcar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentcar.dao.VehicleDAOImpl;
import com.rentcar.entity.Product;
import com.rentcar.entity.Vehicle;

@Transactional
@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private VehicleDAOImpl vehicleDAO;
	
	
	@Override
	public List<Vehicle> getUnlinkedVehicles() {
		return null;
	}
	
	@Override
	public List<Vehicle> getAllVehicles() {
		return vehicleDAO.getAllVehicles();
	}
	
	@Override
	public Vehicle getVehicleById(Long id) {
		return vehicleDAO.getVehicleById(id);
	}

	@Override
	public void addVehicle(Vehicle vehicle) {
		//add vehicle
		vehicleDAO.addVehicle(vehicle);

		//increase stock
		productService.increaseStock(vehicle.getProduct());
	}
	
	@Override
	public void addVehicle(Vehicle vehicle, Product product) {
		//add product
		productService.addProduct(product);
		
		//add vehicle
		vehicleDAO.addVehicle(vehicle);
	}
	
	@Override
	public void deleteVehicle(Long id) {
		Vehicle vehicle = getVehicleById(id);
		Product product = vehicle.getProduct();
		//decrease stock
		productService.decreaseStock(product);
		
		//delete vehicle
		vehicleDAO.deleteVehicle(vehicle);
	}


	@Override
	public void updateVehicle(Vehicle vehicle) {
		//decrease stock old product
		Vehicle oldVehicle = vehicleDAO.getVehicleById(vehicle.getId());
		Product product = productService.getProductById(oldVehicle.getProduct().getId());
		productService.decreaseStock(product);
		
		//increase stock new product
		productService.increaseStock(productService.getProductById(vehicle.getProduct().getId()));
		
		//update vehicle
		vehicleDAO.updateVehicle(vehicle);
	}


	@Override
	public void updateVehicle(Vehicle vehicle, Product product) {
		
		//decrease stock old product
		Vehicle oldVehicle = vehicleDAO.getVehicleById(vehicle.getId());
		Product oldProduct = productService.getProductById(oldVehicle.getProduct().getId());
		productService.decreaseStock(oldProduct);
		
		//add product
		productService.addProduct(product);
		
		//update vehicle
		vehicleDAO.updateVehicle(vehicle);
	}

}

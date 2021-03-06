package com.rentcar.dao;

import java.util.List;

import com.rentcar.entity.Product;
import com.rentcar.entity.Vehicle;

public interface ProductDAO {
	List<Product> getAllProducts();
	List<Vehicle> getVehiclesByProductId(Long id);
	Product getProductById(Long id);
	void addProduct(Product p);
	void updateProduct(Product p);
	void deleteProduct(Long id);
	
}

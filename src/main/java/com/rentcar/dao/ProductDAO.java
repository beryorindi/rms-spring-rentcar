package com.rentcar.dao;

import java.util.List;

import com.rentcar.entity.Car;
import com.rentcar.entity.Product;

public interface ProductDAO {
	List<Product> getAllProducts();
	Product getProductById(Long id);
	void addProduct(Product p);
	void updateProduct(Product p);
	void deleteProduct(Long id);
	boolean productExists(Car car);
}

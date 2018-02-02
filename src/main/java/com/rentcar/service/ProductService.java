package com.rentcar.service;

import java.util.List;

import com.rentcar.entity.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Product getProductById(Long id);
	void addProduct(Product p);
	void updateProduct(Product p);
	void deleteProduct(Long id);
}

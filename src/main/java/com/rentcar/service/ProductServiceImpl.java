package com.rentcar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentcar.dao.ProductDAO;
import com.rentcar.dao.VehicleDAOImpl;
import com.rentcar.entity.Product;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private VehicleDAOImpl vehicleDAO;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDAO.getAllProducts();
	}

	@Override
	public Product getProductById(Long id) {
		return productDAO.getProductById(id);
	}

	@Override
	public void addProduct(Product p) {		
		p.setStock(1);
		p.setAvailable(1);
		productDAO.addProduct(p);
	}

	@Override
	public void updateProduct(Product p) {
		productDAO.updateProduct(p);
	}

	@Override
	public void deleteProduct(Long id) {
		productDAO.deleteProduct(id);
	}

	@Override
	public void increaseStock(Product p) {
		p.setStock(p.getStock() + 1);
		p.setAvailable(p.getAvailable() + 1);
		updateProduct(p);
	}
	
	@Override
	public void decreaseStock(Product p) {
		p.setStock(p.getStock() - 1);
		p.setAvailable(p.getAvailable() - 1);
		updateProduct(p);
	}

}

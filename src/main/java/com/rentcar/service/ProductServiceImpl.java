package com.rentcar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentcar.dao.ProductDAO;
import com.rentcar.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
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
		// TODO Auto-generated method stub
		p.setAvailable(p.getStock());
		productDAO.addProduct(p);
	}

	@Override
	public void updateProduct(Product p) {
		if(!productDAO.productExists(p.getCar())){
			productDAO.updateProduct(p);
		}
	}

	@Override
	public void deleteProduct(Long id) {
		productDAO.deleteProduct(id);
	}

}

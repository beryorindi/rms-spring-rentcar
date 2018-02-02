package com.rentcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rentcar.entity.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}

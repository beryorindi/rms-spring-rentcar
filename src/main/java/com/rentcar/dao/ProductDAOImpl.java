package com.rentcar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.rentcar.entity.Product;
import com.rentcar.entity.Vehicle;

@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		String hql = "FROM Product as prod ORDER BY prod.stock DESC";
		return (List<Product>)em.createQuery(hql).getResultList();
	}

	@Override
	public Product getProductById(Long id) {
		return em.find(Product.class, id);
	}

	@Override
	public void addProduct(Product p) {
		em.persist(p);
	}

	@Override
	public void updateProduct(Product p) {
		em.merge(p);
	}

	@Override
	public void deleteProduct(Long id) {
		em.remove(getProductById(id));
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> getVehiclesByProductId(Long id) {
		String hql = "FROM Vehicle as v WHERE v.product.id = ?";
		return em.createQuery(hql).setParameter(1, id)
				.getResultList();
	}

	

}

package com.rentcar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.rentcar.entity.Car;
import com.rentcar.entity.Product;

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

	@Override
	public boolean productExists(Car car) {
		String hql = "FROM Product as p WHERE p.car.id = ?";
		int count = em.createQuery(hql)
						.setParameter(1, car.getId()).getResultList().size();
		return count > 0 ? true : false;
	}

}

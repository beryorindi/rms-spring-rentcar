package com.rentcar.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.rentcar.entity.Car;

@Transactional
@Repository
public class CarDAOImpl implements CarDAO{
	

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Car> getAllCars() {
		String hql = "FROM Car as car ORDER BY car.brand";
		return (List<Car>)em.createQuery(hql).getResultList();
	}

	@Override
	public Car getCarById(Long id) {
		return em.find(Car.class, id);
	}

	@Override
	public void addCar(Car car) {
		em.persist(car);
	}

	@Override
	public void updateCar(Car car) {
/*		String hql = "UPDATE car SET brand=?, model=?, type=?, transmition=?, year=?, seat=? WHERE id=?";
		em.createQuery(hql)
						.setParameter(1, car.getBrand())
						.setParameter(2, car.getModel())
						.setParameter(3, car.getType())
						.setParameter(4, car.getTransmition())
						.setParameter(5, car.getYear())
						.setParameter(6, car.getSeat())
						.setParameter(7, car.getId());
		em.
		Car obj = getCarById(car.getId());
		obj.setBrand(car.getBrand());
		obj.setModel(car.getModel());
		obj.setSeat(car.getSeat());
		obj.setTransmition(car.getTransmition());
		obj.setType(car.getType());
		obj.setYear(car.getYear());*/
//		em.flush();
		em.merge(car);
	}

	@Override
	public void deleteCar(Long id) {
		em.remove(getCarById(id));
	}

	@Override
	public boolean carExists(String brand, String model, String type) {
		String hql = "FROM Car as car WHERE car.brand = ? and car.model = ? and car.type=?";
		int count = em.createQuery(hql)
						.setParameter(1, brand)
						.setParameter(2, model)
						.setParameter(3, type).getResultList().size();
		return count > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> getUnlikedCars() {
		String hql = "FROM Product as p RIGHT JOIN Car as car ON p.car.id = car.id WHERE p.car.id IS NULL";
		return em.createQuery(hql).getResultList();
	}

}

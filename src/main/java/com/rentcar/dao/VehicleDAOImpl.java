package com.rentcar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rentcar.entity.Car;
import com.rentcar.entity.Product;
import com.rentcar.entity.Vehicle;

@Repository
public class VehicleDAOImpl implements VehicleDAO {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> getAllVehicles() {
		String hql = "FROM Vehicle as vehicle ORDER BY vehicle.brand";
		return (List<Vehicle>)em.createQuery(hql).getResultList();
	}

	/*@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> getUnlikedVehicles() {
		String hql = "FROM Product as p RIGHT JOIN Vehicle as Vehicle ON p.vehicle.id = vehicle.id WHERE p.vehicle.id IS NULL";
		return (List<Vehicle>)em.createQuery(hql).getResultList();
	}*/

	@Override
	public Vehicle getVehicleById(Long id) {
		return em.find(Vehicle.class, id);
	}

	@Override
	public void addVehicle(Vehicle vehicle) {
		em.persist(vehicle);
	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		em.merge(vehicle);
	}

	@Override
	public void deleteVehicle(Vehicle vehicle) {
		em.remove(vehicle);
	}


}

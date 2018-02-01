package com.rentcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentcar.entity.Car;

@Repository("carRepository")
public interface CarRepository extends JpaRepository<Car, Long>{
	Car findByModel(String model);
}

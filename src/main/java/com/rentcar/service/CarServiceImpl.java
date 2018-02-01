package com.rentcar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentcar.dao.CarDAO;
import com.rentcar.entity.Car;

@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarDAO carDAO;
	
	@Override
	public List<Car> getAllCars() {
		return carDAO.getAllCars();
	}

	@Override
	public Car getCarById(Long id) {
		Car obj = carDAO.getCarById(id);
		return obj;
	}

	@Override
	public boolean addCar(Car car) {
		if(carDAO.carExists(car.getBrand(), car.getModel(), car.getType())){
			return false;
		}
		else{
			carDAO.addCar(car);
			return true;
		}
		
	}

	@Override
	public void updateCar(Car car) {
		carDAO.updateCar(car);
	}

	@Override
	public void deleteCar(Long id) {
		carDAO.deleteCar(id);
	}

}

package com.rentcar.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rentcar.entity.Car;
import com.rentcar.service.CarService;

@Controller
//@RequestMapping("admin")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	public String getRole(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = null;
		if (auth.getPrincipal() instanceof UserDetails) {
			role = auth.getAuthorities().toString().toLowerCase();
			role = role.substring(1, role.length()-1);
		}
		return role;
	}
	/*@GetMapping("cars/{id}")
	public ResponseEntity<Car> getArticleById(@PathVariable("id") Long id) {
		Car car = carService.getCarById(id);
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}*/
	
	
	@GetMapping("cars")
	public ModelAndView carsPage(){
		ModelAndView modelAndView = new ModelAndView();
		List<Car> cars = carService.getAllCars();
		modelAndView.addObject("cars", cars);
		modelAndView.setViewName("car/cars");
		return modelAndView;
	}
	@GetMapping("**/cars/add")
//	@GetMapping({"/admin/cars/add","/super_admin/cars/add"})
	public ModelAndView addCarPage(){
		ModelAndView modelAndView = new ModelAndView();
		Car car = new Car();
		modelAndView.addObject("car", car);
		modelAndView.setViewName("car/add");
		return modelAndView;
	}
	@PostMapping("cars/add")
//	@PostMapping({"/admin/cars/add","/super_admin/cars/add"})
	public ModelAndView addCar(@Valid Car car, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("cars/add");
		} else {
		carService.addCar(car);
		//modelAndView.addObject("successMessage", "Car has been added successfully");
		List<Car> cars = carService.getAllCars();
		modelAndView.addObject("cars", cars);
		modelAndView.setViewName("redirect:/cars");
		
		}
		return modelAndView;
	}
	
	@GetMapping("cars/edit/{id}")
//	@GetMapping({"/admin/cars/edit/{id}","/super_admin/cars/edit/{id}"})
	public ModelAndView updateCarPage(@PathVariable("id") Long id){
		ModelAndView modelAndView = new ModelAndView();
		Car car = carService.getCarById(id);
		modelAndView.addObject("car", car);
		modelAndView.setViewName("car/edit");
		return modelAndView;
	}
	
	@PostMapping("cars/edit")
//	@GetMapping({"/admin/cars/edit","/super_admin/cars/edit"})
	public ModelAndView updateCar(@Valid Car car, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("cars/edit");
		} else {
		carService.updateCar(car);
		//modelAndView.addObject("successMessage", "Car has been added successfully");
		List<Car> cars = carService.getAllCars();
		modelAndView.addObject("cars", cars);
		modelAndView.setViewName("redirect:/cars");
		}
		return modelAndView;
	}
	
	@GetMapping("cars/delete/{id}")
//	@GetMapping({"/admin/cars/delete/{id}","/super_admin/cars/delete/{id}"})
	public ModelAndView deleteCar(@PathVariable("id") Long id){
		ModelAndView modelAndView = new ModelAndView();
		carService.deleteCar(id);
		//modelAndView.addObject("successMessage", "Car has been added successfully");
		List<Car> cars = carService.getAllCars();
		modelAndView.addObject("cars", cars);
		modelAndView.setViewName("redirect:/cars");
		return modelAndView;
	}
	
	
}

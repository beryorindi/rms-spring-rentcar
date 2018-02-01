package com.rentcar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rentcar.entity.User;
import com.rentcar.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private UserService userService;
	
	/*@RequestMapping(value="/users", method = RequestMethod.GET)
	public ModelAndView findallUsers(){
		ModelAndView modelAndView = new ModelAndView();
		List<User> users = userService.findAll();
		modelAndView.addObject("users", users);
		modelAndView.setViewName("users");
		return modelAndView;
	}*/
}

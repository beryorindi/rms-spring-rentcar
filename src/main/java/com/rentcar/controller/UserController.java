package com.rentcar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rentcar.entity.User;
import com.rentcar.service.LoginService;
import com.rentcar.service.UserService;
import com.rentcar.service.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/users")
	public ModelAndView userListPage(){
		ModelAndView modelAndView = new ModelAndView();
		List<User> users = userService.getUserList();
		String link = "user";
		modelAndView.addObject("link", link);
		modelAndView.addObject("users", users);
		modelAndView.setViewName("admin/userlist");
		return modelAndView;
	}
	
	@GetMapping("/admins")
	public ModelAndView adminListPage(){
		ModelAndView modelAndView = new ModelAndView();
		List<User> users = userService.getAdminList();
		String link = "admin";
		modelAndView.addObject("link", link);
		modelAndView.addObject("users", users);
		modelAndView.setViewName("admin/userlist");
		return modelAndView;
	}
	
	
	@GetMapping("/users/active/{id}")
	public ModelAndView userActivate(@PathVariable("id") int id){
		ModelAndView modelAndView = new ModelAndView();
		User user = userService.getUserById(id);
		if(user.getActive() == 0){
			user.setActive(1);
		}
		else{
			user.setActive(0);
		}
		userService.updateUser(user);
		List<User> users = userService.getUserList();
		/*String link = "user";
		modelAndView.addObject("link", link);*/
		modelAndView.addObject("users", users);
		modelAndView.setViewName("redirect:/users");
		return modelAndView;
	}
	
	@GetMapping("/admins/active/{id}")
	public ModelAndView adminActivate(@PathVariable("id") int id){
		ModelAndView modelAndView = new ModelAndView();
		User user = userService.getUserById(id);
		if(user.getActive() == 0){
			user.setActive(1);
		}
		else{
			user.setActive(0);
		}
		userService.updateUser(user);
		List<User> users = userService.getAdminList();
		/*String link = "user";
		modelAndView.addObject("link", link);*/
		modelAndView.addObject("users", users);
		modelAndView.setViewName("redirect:/admins");
		return modelAndView;
	}
}

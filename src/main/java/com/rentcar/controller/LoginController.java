package com.rentcar.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rentcar.entity.Product;
import com.rentcar.entity.User;
import com.rentcar.service.ProductServiceImpl;
import com.rentcar.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService userService;
	
	@Autowired
	ProductServiceImpl productService;
	
	public String getRole(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = null;
		if (auth.getPrincipal() instanceof UserDetails) {
			role = auth.getAuthorities().toString().toLowerCase();
			role = role.substring(1, role.length()-1);
		}
		return role;
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView homePage(){
		ModelAndView modelAndView = new ModelAndView();
		List<Product> products = productService.getAllProducts();
		modelAndView.addObject("products", products);
		modelAndView.setViewName("product/products");
		return modelAndView;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();	        
		if (auth.getPrincipal() instanceof UserDetails) {
			String role = auth.getAuthorities().toString().toLowerCase();
			role = role.substring(1, role.length()-1);
	        modelAndView.setViewName("redirect:/"+ role);
		}else{
			modelAndView.setViewName("admin/login");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("admin/registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value={"/super_admin"}, method = RequestMethod.GET)
	public ModelAndView superAdminHome(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
//		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Super Admin Role");
		modelAndView.setViewName("admin/super_admin");
		return modelAndView;
	}
	
	@RequestMapping(value={"/admin"}, method = RequestMethod.GET)
	public ModelAndView adminHome(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
//		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/admin");
		return modelAndView;
	}
	
	@RequestMapping(value={"/user"}, method = RequestMethod.GET)
	public ModelAndView userHome(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		//modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		//modelAndView.addObject("adminMessage","Content Available Only for Users with User Role");
		modelAndView.setViewName("redirect:/");
		return modelAndView;
	}
	
	@RequestMapping(value="/error/403", method = RequestMethod.GET)
	public ModelAndView accessDenied(){
		ModelAndView modelAndView = new ModelAndView();
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with User Role");*/
		modelAndView.setViewName("error/403");
		return modelAndView;
	}
	
	@GetMapping("/setting")
	public ModelAndView settingPage(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName().toString();
		User user = userService.findUserByEmail(email);
		modelAndView.addObject("user", user);
		modelAndView.setViewName("admin/setting/setting");
		return modelAndView;
	}
}

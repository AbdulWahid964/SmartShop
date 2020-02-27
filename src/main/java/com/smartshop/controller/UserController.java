package com.smartshop.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smartshop.entity.Roles;
import com.smartshop.entity.Users;
import com.smartshop.service.UserService;

@RestController
public class UserController {

	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserService userService;

	@RequestMapping("/registration")
	public ModelAndView showUserRegisterForm(){
		
		logger.info("In Show Registration Method");
		return new ModelAndView("registration-page","users",new Users());
	}
	@PostMapping("register")
	public ModelAndView saveUserRegistrationForm(@Validated @ModelAttribute("users") Users users,BindingResult result){

		logger.info("In Save Registration Method");

		if(result.hasErrors()){
			logger.error("Validation Error Occured in Save Registration Method ");
			return new ModelAndView("registration-page");
		}
		users.setEnabled(1);
		users.setEncodedPassword(passwordEncoder.encode(users.getPassword()));
	//	Roles role = new Roles("user");
		Roles role = new Roles("manager");
		users.setRole(role);
		userService.saveUser(users);
		role=null;
		return new ModelAndView("redirect:/login");
	}
}

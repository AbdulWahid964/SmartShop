package com.smartshop.controller;

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

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserService userService;

	@RequestMapping("/showUserRegistration")
	public ModelAndView showUserRegisterForm(){
		return new ModelAndView("registration-page","users",new Users());
	}
	@PostMapping("saveUserRegistrationForm")
	public ModelAndView saveUserRegistrationForm(@Validated @ModelAttribute("users") Users users,BindingResult result){


		System.out.println("saveUserRegistration" );

		//Roles roles= new Roles(users.getRole().getRoles());
		//users.setRole(roles);
		System.out.println("result.hasErrors()" +result.hasErrors());
		if(result.hasErrors()){
			return new ModelAndView("registration-page");
		}
		users.setEnabled(1);
		users.setEncodedPassword(passwordEncoder.encode(users.getPassword()));
		Roles role = new Roles("user");
//		Roles role = new Roles("admin");
		users.setRole(role);
		userService.saveUser(users);

		return new ModelAndView("redirect:/login");


	}
}

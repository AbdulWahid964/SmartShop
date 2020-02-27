package com.smartshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String showLogin(){

		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response,HttpSession session){

		session.invalidate();
		return "redirect:/login";
	}
	@RequestMapping("/accessDenied")
	public String accessDenied(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		return "access-denied";
	}
	
}

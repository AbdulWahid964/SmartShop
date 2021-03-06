package com.smartshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Abdul
 *
 */

@Controller
public class LoginController {

	private static final Logger logger = LogManager.getLogger(UserController.class);

	@RequestMapping("/login")
	public String showLogin() {
		logger.info("In Show Login Method");
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		logger.info("In Logout Method");
		session.invalidate();
		return "redirect:/login";
	}

	@RequestMapping("/accessDenied")
	public String accessDenied(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		logger.info("In Access Denied Method");
		return "access-denied";
	}

}

package com.smartshop.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smartshop.service.ProductService;

/**
 * @author Abdul,Indu,varun
 *
 */
@RestController
public class HomeController {
	private static final Logger logger = LogManager.getLogger(HomeController.class);

	@Autowired
	ProductService productservice;

	@RequestMapping("/")
	public ModelAndView showLogin(Model model) {

		logger.info("In showLogin Method");

		return new ModelAndView("login");

	}

	@RequestMapping("/home")
	public ModelAndView showHome(Model model) {

		logger.info("In Home Controller and setting roles");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = auth.getAuthorities().toString();
		model.addAttribute("role", role);
		model.addAttribute("productList", productservice.showProducts());
		return new ModelAndView("home");

	}

}

package com.smartshop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

	
	@RequestMapping("/home")
	public ModelAndView showHome(Model model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String role= auth.getAuthorities().toString();
	    model.addAttribute("role",role);
	    
	    return new ModelAndView("home");
//		return new ModelAndView("/home", "list", list);
	    
	}

}

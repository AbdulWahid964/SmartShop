package com.smartshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smartshop.entity.Stock;
import com.smartshop.service.StockService;

@RestController
public class StockController {

	
	@Autowired
	StockService stockService;
	
	@RequestMapping("/stock")
	public ModelAndView showStock(){
		
		return new ModelAndView("stock","stock",new Stock());
	}
	@PostMapping("/stock")
	public ModelAndView saveStock(@ModelAttribute("stock") Stock stock){
		stockService.saveStock(stock);
		return new ModelAndView("redirect:/home");
	}
	
	
	
}

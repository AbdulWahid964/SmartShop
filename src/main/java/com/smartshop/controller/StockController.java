package com.smartshop.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smartshop.entity.Stock;
import com.smartshop.exception.ProductIdNotFoundException;
import com.smartshop.service.StockService;

@RestController
public class StockController {

	private static final Logger logger = LogManager.getLogger(HomeController.class);
	
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
	@GetMapping("/stock/{stockId}")
	public ModelAndView editStock(@PathVariable("stockId") int stockId) {

		logger.info("In editProduct method");

		Stock stock=stockService.editStock(stockId);
		if (stock==null) {
			logger.error("Stock Id is not Found ");
			throw new ProductIdNotFoundException("Stock Id not Found exception");
		}
		return new ModelAndView("stock","stock",stock);
	}
	
	
}

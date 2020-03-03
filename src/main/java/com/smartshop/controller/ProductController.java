package com.smartshop.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smartshop.entity.Product;
import com.smartshop.exception.ProductIdNotFoundException;
import com.smartshop.exception.ResourceNotFoundException;
import com.smartshop.service.ProductService;

/**
 * @author Abdul,Indu,Varun,nithya,Gandhi
 *
 */

@RestController
public class ProductController {

	private static final Logger logger = LogManager.getLogger(HomeController.class);

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/product")
	public ModelAndView addProduct(@ModelAttribute("product") Product products) {

		logger.info("In addProduct method");

		return new ModelAndView("product");
	}

	@PostMapping(value = "/product")
	public ModelAndView saveProduct(@Validated @ModelAttribute("product") Product product, BindingResult result) {

		logger.info("In saveProduct method");
		
		if (result.hasErrors()) {

			logger.info("Validation Error");
			return new ModelAndView("product");
		}
		productService.saveProduct(product);
		return new ModelAndView("redirect:/home");
	}

	@GetMapping(value = "/products/product/{productId}")
	public ModelAndView deleteProduct(@PathVariable("productId") int productId, Model model) {

		try {
			logger.info("In deleteProduct method");

			productService.deleteProduct(productId);

			model.addAttribute("productList", productService.showProducts());

			return new ModelAndView("redirect:/home");

		} catch (Exception e) {

			throw new ProductIdNotFoundException("Invalid Product Id");
		}
	}

	@GetMapping("/product/{productId}")
	public ModelAndView editProduct(@PathVariable("productId") int productId) {

		logger.info("In editProduct method");

		Product product = productService.editProduct(productId);
		if (product == null) {

			logger.error("Product is null");

			throw new ResourceNotFoundException("Product Not Found Exception");
		}
		return new ModelAndView("product", "product", product);
	}

	@GetMapping("/products")
	public ModelAndView searchProductName(@RequestParam("productname") String productName, Model model){

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = auth.getAuthorities().toString();
		model.addAttribute("role", role);

		logger.info("In searchProductName method");

		Product product = new Product();
		product.setProductName(productName);

		List<Product> productList = productService.searchProduct(productName);
		model.addAttribute("product", product);
		model.addAttribute("productList", productList);

		product = null;
		productList = null;
		return new ModelAndView("home");
	}

}

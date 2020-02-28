package com.smartshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smartshop.entity.Product;
import com.smartshop.exception.ResourceNotFoundException;
import com.smartshop.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping(value = "/addproduct")
	public ModelAndView addProduct(@ModelAttribute("products") Product products) {
		return new ModelAndView("saveproduct");
	}

	@PostMapping(value = "/product")
	public ModelAndView saveProduct(@Validated @ModelAttribute("products") Product product, BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("saveproduct");
		}
		productService.saveProduct(product);
		return new ModelAndView("redirect:home");
	}

	@GetMapping(value = "/remove/{productId}")
	public ModelAndView deleteProduct(@PathVariable("productId") int productId, Model model) {

		productService.deleteProduct(productId);
		model.addAttribute("list", productService.showProducts());
		return new ModelAndView("home");
	}

	@GetMapping("/edit/{productId}")
	public ModelAndView editProductForm(@PathVariable("productId") int productId) {

		Product product = productService.editProduct(productId);
		if (product == null) {
			throw new ResourceNotFoundException("Product Not Found Exception");
		}
		return new ModelAndView("saveproduct", "products", product);
	}
}

package com.smartshop.service;

import java.util.List;

import com.smartshop.entity.Product;

public interface ProductService {

	public void saveProduct(Product product);

	public List<Product> showProducts();

	public Product editProduct(int productId);

	public void deleteProduct(int productId);

	public List<Product> searchProduct(String productName);

}

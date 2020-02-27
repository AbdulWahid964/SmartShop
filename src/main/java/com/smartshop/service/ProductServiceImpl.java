package com.smartshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartshop.dao.ProductDao;
import com.smartshop.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public void saveProduct(Product product) {
		if (product.getProductId() > 0) {
			Product prodObj = productDao.findOne(product.getProductId());
			if (prodObj.getProductId() > 0) {
				prodObj.setProductName(product.getProductName());
				prodObj.setProductPrice(product.getProductPrice());
				prodObj.setQuantity(product.getQuantity());
				prodObj.setDescription(product.getDescription());
				productDao.save(prodObj);
			}
		}
		productDao.save(product);
	}

	@Override
	public List<Product> showProducts() {
		return (List<Product>) productDao.findAll();
	}

	@Override
	public Product editProduct(int productId) {
		return productDao.findOne(productId);
	}

	@Override
	public void deleteProduct(int productId) {
		productDao.delete(productId);
	}

}

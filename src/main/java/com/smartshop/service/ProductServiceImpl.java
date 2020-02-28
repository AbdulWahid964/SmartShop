package com.smartshop.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartshop.controller.HomeController;
import com.smartshop.dao.ProductDao;
import com.smartshop.entity.Product;

/*Author Indu/varun*/

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = LogManager.getLogger(HomeController.class);

	@Autowired
	ProductDao productDao;

	@Override
	public void saveProduct(Product product) {

		logger.info("In saveProduct Service ");
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
		logger.info("In showProducts service method ");
		return (List<Product>) productDao.findAll();
	}

	@Override
	public Product editProduct(int productId) {
		logger.info("In editProduct service method ");
		return productDao.findOne(productId);
	}

	@Override
	public void deleteProduct(int productId) {
		logger.info("In deleteProduct service method ");
		productDao.delete(productId);
	}

	@Override
	public List<Product> searchProduct(String productName) {
		logger.info("In searchProduct service method");
		return productDao.findByProductName(productName);
	}

}

package com.smartshop.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.smartshop.entity.Product;

/**
 * @author Indu,Varun
 *
 */
public interface ProductDao extends CrudRepository<Product, Integer> {

	List<Product> findByProductName(String productName);
}

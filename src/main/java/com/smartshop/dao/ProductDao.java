package com.smartshop.dao;

import org.springframework.data.repository.CrudRepository;

import com.smartshop.entity.Product;

public interface ProductDao extends CrudRepository<Product, Integer> {

}

package com.smartshop.dao;

import org.springframework.data.repository.CrudRepository;

import com.smartshop.entity.Stock;

public interface StockDAO  extends CrudRepository<Stock,Integer>{
}

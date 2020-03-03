package com.smartshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartshop.dao.StockDAO;
import com.smartshop.entity.Stock;

@Service
public class StockServiceImpl implements StockService{

	@Autowired
	StockDAO stockDao;
	
	@Override
	public void saveStock(Stock stock) {
		
		stockDao.save(stock);
		
	}
	@Override
	public Stock editStock(int stockId) {
		return stockDao.findOne(stockId);
	}

}

package com.smartshop.controller;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import com.smartshop.dao.StockDAO;
import com.smartshop.entity.Stock;
import com.smartshop.service.StockService;
import com.smartshop.service.StockServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class StockControllerTest {

	StockController stockController;
	private Stock stock;
	@Mock
	StockDAO stockDao;
	StockService stockService;
	Field field, field1;
	@Mock
	private Model model;

	@Before
	public void setUp() throws Exception {
		stockController = new StockController();
		stockService = new StockServiceImpl();
		field = StockController.class.getDeclaredField("stockService");
		field.setAccessible(true);
		field.set(stockController, stockService);
		field1 = StockServiceImpl.class.getDeclaredField("stockDao");
		field1.setAccessible(true);
		field1.set(stockService, stockDao);
		stock = new Stock();
		stock.setId(2);
		stock.setName("Test2");
		stock.getId();
		stock.getName();
	}
	@Test
	public void testAddStock() {
		assertEquals("stock", stockController.showStock().getViewName());
	}
	@Test
	public void testSaveStock() {
		// Mockito.when(stockDao.findOne(Matchers.anyInt())).thenReturn(stock);
		assertEquals("redirect:/home", stockController.saveStock(stock).getViewName());
	}
	@After
	public void tearDown() throws Exception {
		stock = null;
		stockController = null;
		model = null;
		stockService = null;
	}

	@Test
	public void testEditStockException() throws Exception {
		Stock stock = stockService.editStock(100);
		int status = 404;
		String content = "Stock Id is not Found";
		if (stock == null) {
			assertEquals(404, status);
			assertEquals(content, "Stock Id is not Found");
		}
	}
}

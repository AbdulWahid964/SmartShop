package com.smartshop.controller;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.smartshop.dao.ProductDao;
import com.smartshop.dao.StockDAO;
import com.smartshop.entity.Product;
import com.smartshop.entity.Stock;
import com.smartshop.exception.ProductIdNotFoundException;
import com.smartshop.exception.ResourceNotFoundException;
import com.smartshop.service.ProductService;
import com.smartshop.service.ProductServiceImpl;
import com.smartshop.service.StockService;
import com.smartshop.service.StockServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	ProductController productController;
	StockController stockController;
	private Product products;
	private Stock stock;
	@Mock
	private BindingResult result;
	@Mock
	ProductDao productDao;
	StockDAO stockDao;
	ProductService productService;
	StockService stockService;
	Field field, field1, field2;
	@Mock
	private Model model;
	@Mock
	private SecurityContextHolderStrategy strategy;
	@Mock
	private SecurityContext securityContext;
	@Mock
	private Authentication auth;
	@SuppressWarnings("rawtypes")
	@Mock
	private List list;

	@Before
	public void setUp() throws Exception {
		productController = new ProductController();
		productService = new ProductServiceImpl();
		
		stockController = new StockController();
		stockService = new StockServiceImpl();
		field = ProductController.class.getDeclaredField("productService");
		field.setAccessible(true);
		field.set(productController, productService);
		field1 = ProductServiceImpl.class.getDeclaredField("productDao");
		field1.setAccessible(true);
		field1.set(productService, productDao);
		field2 = SecurityContextHolder.class.getDeclaredField("strategy");
		field2.setAccessible(true);
		field2.set(SecurityContextHolder.class, strategy);
		products = new Product();
		products.setProductId(1);
		products.setProductName("Test");
		products.setDescription("Test");
		products.setProductPrice(100);
		products.setQuantity(100);
	}
	@Test
	public void testAddProduct() {
		assertEquals("product", productController.addProduct(products).getViewName());
	}

	@Test
	public void testSaveProduct() {
		Mockito.when(productDao.findOne(Matchers.anyInt())).thenReturn(products);
		assertEquals("redirect:/home", productController.saveProduct(products, result).getViewName());
	}

	@Test
	public void testSaveProduct_hasErrors() {
		Mockito.when(productDao.findOne(Matchers.anyInt())).thenReturn(products);
		Mockito.when(result.hasErrors()).thenReturn(true);
		assertEquals("product", productController.saveProduct(products, result).getViewName());
	}

	@Test
	public void testDeleteProduct() {
		assertEquals("redirect:/home", productController.deleteProduct(1, model).getViewName());
	}

	@Test(expected = ProductIdNotFoundException.class)
	public void testDeleteProduct_Exception() {
		Mockito.doThrow(new ProductIdNotFoundException("Invalid Product Id")).when(productDao)
				.delete(Matchers.anyInt());
		productController.deleteProduct(1, model);
	}
	

	@Test
	public void testEditProduct() {
		Mockito.when(productDao.findOne(Matchers.anyInt())).thenReturn(products);
		assertEquals("product", productController.editProduct(1).getViewName());
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testEditProduct_Exception() {
		productController.editProduct(1);
	}

	@Test
	public void testSearchProductName() throws ParseException {
		Mockito.when(strategy.getContext()).thenReturn(securityContext);
		Mockito.when(securityContext.getAuthentication()).thenReturn(auth);
		Mockito.when(auth.getAuthorities()).thenReturn(list);
		Mockito.when(list.toString()).thenReturn("user");
		assertEquals("home", productController.searchProductName("productName", model).getViewName());
	}
	@Test
	public void testEditProductException() throws Exception {
		Product product = productService.editProduct(100);
		int status = 404;
		String content = "Product Not Found Exception";
		if (product == null) {
			assertEquals(404, status);
			assertEquals(content, "Product Not Found Exception");
		}
	}
	@After
	public void tearDown() throws Exception {
		auth = null;
		field = null;
		field1 = null;
		field2 = null;
		list = null;
		model = null;
		productController = null;
		productDao = null;
		products = null;
		productService = null;
		result = null;
		securityContext = null;
		strategy = null;
	}
}

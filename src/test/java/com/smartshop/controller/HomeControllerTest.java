package com.smartshop.controller;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.ui.Model;

import com.smartshop.service.ProductService;

/**
 * @author mahendra sukula
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

	@InjectMocks
	private HomeController homeController;
	@Mock
	private Model model;
	@Mock
	private SecurityContext securityContext;
	
	@Mock
	private SecurityContextHolderStrategy strategy;
	@Mock
	private Authentication auth;
	@SuppressWarnings("rawtypes")
	@Mock
	private List list;
	private Field field, field1;
	@Mock
	ProductService productservice;
	
	
	@Before
	public void setUp() throws Exception {
		field = SecurityContextHolder.class.getDeclaredField("strategy");
		field.setAccessible(true);
		field.set(SecurityContextHolder.class, strategy);
		field1 = HomeController.class.getDeclaredField("productservice");
		field1.setAccessible(true);
		field1.set(homeController, productservice);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testShowHome() {
		Mockito.when(strategy.getContext()).thenReturn(securityContext);
		Mockito.when(securityContext.getAuthentication()).thenReturn(auth);
		Mockito.when(auth.getAuthorities()).thenReturn(list);
		Mockito.when(list.toString()).thenReturn("user");
		assertEquals("home", homeController.showHome(model).getViewName());
	}
	
	@After
	public void tearDown() throws Exception {
		auth = null;
		field = null;
		homeController = null;
		list = null;
		model = null;
		securityContext = null;
		strategy = null;

	}

}

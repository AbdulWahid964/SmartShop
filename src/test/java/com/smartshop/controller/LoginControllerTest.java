package com.smartshop.controller;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author mahendra sukula
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@InjectMocks
	private LoginController loginController;
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Mock
	private HttpSession session;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShowLogin() {
		assertEquals("login", loginController.showLogin());
	}

	@Test
	public void testLogout() {
		assertEquals("redirect:/login", loginController.logout(request, response, session));
	}

	@Test
	public void testAccessDenied() {
		assertEquals("access-denied", loginController.accessDenied(request, response, session));
	}

	@After
	public void tearDown() throws Exception {
		loginController = null;
		request = null;
		response = null;
		session = null;
	}
}

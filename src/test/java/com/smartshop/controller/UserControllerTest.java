package com.smartshop.controller;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;

import com.smartshop.dao.UsersDao;
import com.smartshop.entity.Users;
import com.smartshop.service.UserService;
import com.smartshop.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@InjectMocks
	private UserController userController;
	@Mock
	private BindingResult result;
	@Mock
	private PasswordEncoder passwordEncoder;
	@Mock
	private UsersDao usersDao;
	private UserService userService;

	private Users users;
	private Field field, field1, field2;

	@Before
	public void setUp() throws Exception {
		users = new Users();
		users.setPassword("Pass@1234");

		field = UserController.class.getDeclaredField("passwordEncoder");
		field.setAccessible(true);
		field.set(userController, passwordEncoder);

		userService = new UserServiceImpl();
		field1 = UserController.class.getDeclaredField("userService");
		field1.setAccessible(true);
		field1.set(userController, userService);

		field2 = UserServiceImpl.class.getDeclaredField("usersDao");
		field2.setAccessible(true);
		field2.set(userService, usersDao);
	}

	@Test
	public void testShowUserRegisterForm() {
		assertEquals("registration-page", userController.showUserRegisterForm().getViewName());
	}

	@Test
	public void testSaveUserRegistrationForm() {
		assertEquals("redirect:/login", userController.saveUserRegistrationForm(users, result).getViewName());
	}

	@Test
	public void testSaveUserRegistrationForm_BindingResultHasErrors() {
		Mockito.when(result.hasErrors()).thenReturn(true);
		assertEquals("registration-page", userController.saveUserRegistrationForm(users, result).getViewName());
	}

	@After
	public void tearDown() throws Exception {
		result = null;
		field = null;
		passwordEncoder = null;
		userController = null;
		users = null;
		usersDao = null;
		userService = null;
		field1 = null;
		field2 = null;
	}

}

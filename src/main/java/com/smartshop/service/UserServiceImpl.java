package com.smartshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartshop.dao.UsersDao;
import com.smartshop.entity.Users;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UsersDao usersDao;
	
	@Override
	public void saveUser(Users users) {
		usersDao.save(users);
		
	}

	@Override
	public Users getUserName(String name) {
		Users users	= usersDao.findByUserName(name);
		return users;
	}

}

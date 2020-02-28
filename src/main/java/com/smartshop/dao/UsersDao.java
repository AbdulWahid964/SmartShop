package com.smartshop.dao;

import org.springframework.data.repository.CrudRepository;

import com.smartshop.entity.Users;

/**
 * @author Abdul
 *
 */
public interface UsersDao extends CrudRepository<Users, Integer> {

}

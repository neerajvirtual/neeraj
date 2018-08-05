package com.demo.dao;

import java.util.List;

import com.demo.modelBO.UsersBO;

public interface UsersDao {

	List<UsersBO> getActiveUsers();

	UsersBO addUser(UsersBO userbo);

}
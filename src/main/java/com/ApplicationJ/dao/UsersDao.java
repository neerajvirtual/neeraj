package com.ApplicationJ.dao;

import java.util.List;

import com.ApplicationJ.modelBO.UsersBO;

public interface UsersDao {

	List<UsersBO> getActiveUsers();

	UsersBO addUser(UsersBO userbo);

	UsersBO getUserById(int id);

}
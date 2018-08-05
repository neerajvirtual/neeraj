package com.demo.service;

import java.util.List;

import com.demo.modelBO.UsersBO;
import com.demo.modelTO.UsersTO;

public interface UsersService {

	List<UsersTO> getActiveUsers();

	UsersBO addUser(UsersBO userto);

}
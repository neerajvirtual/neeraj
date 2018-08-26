package com.ApplicationJ.service;

import java.util.List;

import com.ApplicationJ.modelBO.UsersBO;
import com.ApplicationJ.modelTO.UsersTO;

public interface UsersService {

	List<UsersTO> getActiveUsers();

	UsersBO addUser(UsersBO userto);

	UsersTO getUsersById(int id);

}
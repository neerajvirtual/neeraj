package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UsersDao;
import com.demo.modelBO.UsersBO;
import com.demo.modelTO.UsersTO;

@Transactional
@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersDao usersdao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<UsersTO> getActiveUsers(){
		List<UsersTO> usersToList = new ArrayList();
		List<UsersBO> usersBoList= usersdao.getActiveUsers();
		for (UsersBO usersBO : usersBoList) {
			usersToList.add(modelMapper.map(usersBO, UsersTO.class));
		}
		return usersToList;
	}
	
	@Override
	public UsersBO addUser(UsersBO userbo) {
		return usersdao.addUser(userbo);
	}
	
}

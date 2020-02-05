package com.ApplicationJ.service;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApplicationJ.dao.UsersDao;
import com.ApplicationJ.modelBO.FoodBO;
import com.ApplicationJ.modelBO.FoodTypeBO;
import com.ApplicationJ.modelBO.StatusBO;
import com.ApplicationJ.modelBO.UsersBO;
import com.ApplicationJ.modelTO.FoodTO;
import com.ApplicationJ.modelTO.FoodTypeTO;
import com.ApplicationJ.modelTO.StatusTO;
import com.ApplicationJ.modelTO.UsersTO;

@Transactional
@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersDao usersdao;
	
	@Autowired
	private ModelMapper modelMapper;

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	
	
	public UsersServiceImpl() {
		super();
		System.out.println("constructor call 0380");
	}
	
	@PostConstruct
	public void helloOnce() {
		System.out.println("0380 post constructor");
	}
	
	@PreDestroy
	public void hellbye() {
		System.out.println("0380 destory method called");
	}

	@Override
	public List<UsersTO> getActiveUsers(){
		List<UsersTO> usersToList = new ArrayList();
		List<UsersBO> usersBoList= usersdao.getActiveUsers();
		for (UsersBO usersBO : usersBoList) {
			if(usersBO.getStatus().getStatus_id()==1) {
				usersToList.add(modelMapper.map(usersBO, UsersTO.class));				
			}
		}
		return usersToList;
	}
	
	@Override
	public UsersBO addUser(UsersBO userbo) {
		return usersdao.addUser(userbo);
	}
	
	@Override
	public UsersTO getUsersById(int id) {
		UsersBO obj= usersdao.getUserById(id);
		return modelMapper.map(obj, UsersTO.class);
	}
	
	@Override
	public UsersBO updateUser(UsersBO userbo) {
		return usersdao.updateUser(userbo);
	}

	@Override
	public List<StatusTO> getStatusList() {
		List<StatusTO> statusToList = new ArrayList();
		List<StatusBO> statusBOList= usersdao.getStatusList();
		for (StatusBO statusBO : statusBOList) {
			statusToList.add(modelMapper.map(statusBO, StatusTO.class));
		}
		return statusToList;
	}

	@Override
	public List<FoodTypeTO> getFoodTypeList() {
		List<FoodTypeTO> foodTypeList = new ArrayList();
		List<FoodTypeBO> foodTypeBOList= usersdao.getFoodTypeList();
		for (FoodTypeBO foodtypebo : foodTypeBOList) {
			foodTypeList.add(modelMapper.map(foodtypebo, FoodTypeTO.class));
		}
		return foodTypeList;
	}

	@Override
	public List<FoodTO> getFoodList() {
		List<FoodTO> foodList = new ArrayList();
		List<FoodBO> foodBOList= usersdao.getFoodList();
		for (FoodBO foodbo : foodBOList) {
			foodList.add(modelMapper.map(foodbo, FoodTO.class));
		}
		return foodList;
	}
	
	@Override
	public List<UsersTO> getTestList() {
		List<UsersTO> usersToList = new ArrayList<UsersTO>();
		List<UsersBO> usersBoList= usersdao.getTestlList();
		for (UsersBO usersBO : usersBoList) {
			usersToList.add(modelMapper.map(usersBO, UsersTO.class));
		}
		return usersToList;
	}

	@Override
	public List<UsersTO> getActiveUsersNameEmail() {
		List<UsersTO> usersToList = new ArrayList<UsersTO>();
		List<UsersBO> usersBoList= usersdao.getActiveUserNameEmailList();
		for (UsersBO usersBO : usersBoList) {
			usersToList.add(modelMapper.map(usersBO, UsersTO.class));
		}
		return usersToList;
	}
	
}

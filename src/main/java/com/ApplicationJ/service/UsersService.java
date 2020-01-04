package com.ApplicationJ.service;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ApplicationJ.modelBO.UsersBO;
import com.ApplicationJ.modelTO.FoodTO;
import com.ApplicationJ.modelTO.FoodTypeTO;
import com.ApplicationJ.modelTO.StatusTO;
import com.ApplicationJ.modelTO.UsersTO;

public interface UsersService {
	
	static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	List<UsersTO> getActiveUsers();

	UsersBO addUser(UsersBO userto);

	UsersTO getUsersById(int id);

	List<StatusTO> getStatusList();

	List<FoodTypeTO> getFoodTypeList();

	List<UsersTO> getTestList();

	List<FoodTO> getFoodList();

	UsersBO updateUser(UsersBO userbo);

}
package com.ApplicationJ.dao;

import java.util.List;

import com.ApplicationJ.modelBO.FoodBO;
import com.ApplicationJ.modelBO.FoodTypeBO;
import com.ApplicationJ.modelBO.StatusBO;
import com.ApplicationJ.modelBO.UsersBO;

public interface UsersDao {

	List<UsersBO> getActiveUsers();

	UsersBO addUser(UsersBO userbo);

	UsersBO getUserById(int id);

	List<StatusBO> getStatusList();

	List<FoodTypeBO> getFoodTypeList();

	List<FoodBO> getFoodList();

	List<UsersBO> getActiveUserNameEmailList();

	UsersBO updateUser(UsersBO userbo);

}
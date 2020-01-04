package com.ApplicationJ.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ApplicationJ.modelBO.UsersBO;
import com.ApplicationJ.modelTO.FoodTO;
import com.ApplicationJ.modelTO.FoodTypeTO;
import com.ApplicationJ.modelTO.ResponseTO;
import com.ApplicationJ.modelTO.StatusTO;
import com.ApplicationJ.modelTO.UsersTO;
import com.ApplicationJ.service.UsersService;
import com.ApplicationJ.utility.Constant;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UsersRestController {

	@Autowired
	ResponseTO response;
	
	@Autowired
	UsersService usersservice;
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> getActiveUsers() throws Exception {
		List<UsersTO> list = usersservice.getActiveUsers();
		responseBuilder(200, "Users List Got Successfully", "users", Constant.USR001, list);
		return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@PathVariable("id") int id) throws Exception {
		UsersTO user = usersservice.getUsersById(id);
		responseBuilder(200, "Users Got Successfully", "users", Constant.USR002, user);
		return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody UsersBO usersbo) throws Exception {
		UsersBO returnObj= usersservice.addUser(usersbo);
		responseBuilder(200, "User Added Successfully", "users", Constant.USR003, returnObj);
		return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody UsersBO usersbo) throws Exception {
		UsersBO returnObj= usersservice.updateUser(usersbo);
		responseBuilder(200, "User Updated Successfully", "users", Constant.USR004, returnObj);
		return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/statusList", method = RequestMethod.GET)
	public ResponseEntity<?> getStatusList() throws Exception {
		List<StatusTO> list = usersservice.getStatusList();
		responseBuilder(200, "Status List Got Successfully", "users", Constant.USR005, list);
		return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/foodTypeList", method = RequestMethod.GET)
	public ResponseEntity<?> getFoodTypeList() throws Exception {
		List<FoodTypeTO> list = usersservice.getFoodTypeList();
		responseBuilder(200, "FoodType List Got Successfully", "users", Constant.USR006, list);
		return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/foodList", method = RequestMethod.GET)
	public ResponseEntity<?> getFoodList() throws Exception {
		List<FoodTO> list = usersservice.getFoodList();
		responseBuilder(200, "Food List Got Successfully", "users", Constant.USR007, list);
		return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<?> getTest() throws Exception {
		List<UsersTO> list = usersservice.getTestList();
		responseBuilder(200, "Users List Got Successfully", "users", Constant.USR008, list);
		return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
	}
	
	private void responseBuilder(int status, String message, String key, String code, Object data) {
		response = new ResponseTO();
		response.setStatus(status);
		response.setPath("/users");
		response.setMessage(message);
		response.setCode(code);
		response.putData(key, data);
	}
	
}
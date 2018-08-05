package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.modelBO.UsersBO;
import com.demo.modelTO.ResponseTO;
import com.demo.modelTO.UsersTO;
import com.demo.service.UsersService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UsersRestController {

	@Autowired
	ResponseTO response;
	
	@Autowired
	UsersService usersservice;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> getActiveUsers() throws Exception {
		List<UsersTO> list = usersservice.getActiveUsers();
		responseBuilder(200, "Users List Got Successfully", "users", list);
		return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody UsersBO usersbo) throws Exception {
		UsersBO returnObj= usersservice.addUser(usersbo);
		responseBuilder(200, "Users List Got Successfully", "users", returnObj);
		return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
	}
	
	private void responseBuilder(int status, String message, String key, Object data) {
		response = new ResponseTO();
		response.setStatus(status);
		response.setPath("/users");
		response.setMessage(message);
		response.putData(key, data);
	}
	
}
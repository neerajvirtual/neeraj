package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.ResponseDTO;
import com.demo.model.Student;
import com.demo.service.UserService;

@RestController
public class RestHomeController {
	
	@Autowired
	UserService userservice;
	
	private ResponseDTO response;
	
	@ResponseBody
	@RequestMapping(value = "/welcomerest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllCurrencies() {
		List<Student> userData = userservice.getAllUsers();
		responseBuilder(200, "CUR005", "655454", userData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	private void responseBuilder(int status, String code, String message, Object data) {
		response = new ResponseDTO();
		response.setStatus(status);
		response.setPath("/students");
		response.setMessage(message);
		response.setCode(code);
		response.putData("student", data);

	}
	
}

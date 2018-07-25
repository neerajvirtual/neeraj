package com.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.app.ApplicationConstants;
import com.demo.model.Student;
import com.demo.model.UserModel;
import com.demo.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService userservice;

	private ApplicationConstants values;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@ResponseBody
	@RequestMapping(value="/welcome", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	String welcome() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		//values.setUniqueNumber(number);
		return "Yours Welcome";
	}
	
	@ResponseBody
	@RequestMapping(value="/set", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	String setStatic() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		values.setUniqueNumber(number);
		return String.valueOf(number);
	}
	
	@ResponseBody
	@RequestMapping(value="/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	String getStatic() {
		return String.valueOf(values.getUniqueNumber());
	}
	
	@RequestMapping("/")
	public String entry() {
	return "home";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView users(ModelAndView modelAndView) {
		System.out.println("landed in user controller from sysout");
		LOGGER.debug("landed in user controller from logger");
		modelAndView.addObject("msg", "All Users Detail");
		modelAndView.setViewName("users");
		return modelAndView;
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(ModelAndView modelAndView, @ModelAttribute UserModel user){
		System.out.println("bean data "+user);
		userservice.saveUser(user);
		modelAndView.setViewName("users");
		return modelAndView;
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ModelAndView addUser(ModelAndView modelAndView, @ModelAttribute Student student){
		userservice.saveStudent(student);
		modelAndView.setViewName("users");
		return modelAndView;
	}
	
}

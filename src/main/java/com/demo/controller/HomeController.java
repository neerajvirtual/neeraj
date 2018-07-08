package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Student;
import com.demo.model.UserModel;
import com.demo.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService userservice;

	@ResponseBody
	@RequestMapping(value="/welcome", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	String welcome() {
		return "Yours Welcome";
	}
	
	@RequestMapping("/")
	public String entry() {
	return "home";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView users(ModelAndView modelAndView) {
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

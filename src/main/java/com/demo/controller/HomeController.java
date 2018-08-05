package com.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@ResponseBody
	@RequestMapping(value="/welcome", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	String welcome() {
		return "Yours Welcome";
	}
	
}

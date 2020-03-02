package com.ApplicationJ.controller;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.text.MessageFormat;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ApplicationJ.utility.Constant;

@Controller
public class HomeController {
    
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@ResponseBody
	@RequestMapping(value = "/welcome", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	String welcome() {
		return Constant.WEl001;
	}
	
	@ResponseBody
	@RequestMapping(value = "/profile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	String showProfile() {
		try {
			Resource resource = null;
			Properties props = PropertiesLoaderUtils
					.loadProperties(new ClassPathResource("/application.properties"));
			if (props.getProperty("spring.profiles.active").equals("dev")) {
				resource = new ClassPathResource("/application-dev.properties");
				props = PropertiesLoaderUtils.loadProperties(resource);
				System.out.println();
				return MessageFormat.format(Constant.WEl002, props.getProperty("application.name"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

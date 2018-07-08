package com.demo.common;

import java.sql.ResultSet;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AOP {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	@AfterReturning(pointcut = "execution(* com.demo..*(..))", returning = "result")
//	public void logBefore(JoinPoint joinPoint, Object result) {
//		logger.debug("going into the method: "+joinPoint.getSignature().getName());
//		logger.debug("get class name "+joinPoint.getTarget().getClass().getName());
//		logger.debug("method return data :", result.toString());
//		logger.debug("printing arguments"+ Arrays.toString(joinPoint.getArgs()));
//	}
	
	@Before("execution(* com.demo..*(..))")
	public void logBefore(JoinPoint joinPoint) {
		logger.debug("going into the method: "+joinPoint.getSignature().getName());
		System.out.println("hi its testing");
		logger.debug("get class name "+joinPoint.getTarget().getClass().getName());
		logger.debug("printing arguments"+ Arrays.toString(joinPoint.getArgs()));
	}
}
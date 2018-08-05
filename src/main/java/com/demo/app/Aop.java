package com.demo.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aop {

	private static final Logger logger = LoggerFactory.getLogger(Aop.class);
	
	@Before("execution(* com.demo..*(..))")
	public void logBefore(JoinPoint joinPoint) {
		logger.debug("BeforeExecution: "+joinPoint.getSignature().getName());
	}
	
}

package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private static Logger log = Logger.getRootLogger();
	@AfterReturning(pointcut="within(com.revature.controller.*)")
	public void logBefore(JoinPoint jp){
		log.info(jp.getThis().toString());
		log.info(jp.getTarget().toString());
	}
	
	@AfterReturning(pointcut="execution(* addPost(..))")
	public void afterPosting(JoinPoint jp){
		log.info(jp.getThis().toString());
	}
}

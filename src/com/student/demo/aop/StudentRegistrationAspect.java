package com.student.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentRegistrationAspect {

	private Logger logger = Logger.getLogger(getClass().getName());

	//	Define the point cut declarations
	
	/**
	 * For: 
	 * - any class present within the controller package  (first * )and 
	 * - any method present within the class (second *)
	 * - with any number of parameter (..)
	 */
	@Pointcut("execution(* com.student.demo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.student.demo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.student.demo.repository.*.*(..))")
	private void forRepositoryPackage() {}
	
	/**
	 * This is how you can combine multiple pointcut expressions
	 */
	@Pointcut("forControllerPackage() || forServicePackage() || forRepositoryPackage()")
	private void forApplication() {}

	/**
	 * Once we setup our pointcut declarations, we can now setup our advice
	 */
	
	@Before("forApplication()")
	public void before(JoinPoint joinPoint) {
		
		// To log the name of the method
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("Information in @Before Advice: Calling the method: "+ methodName);
	}
	
	/**
	 * In this case 'result' is the data returned by the method
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(pointcut = "forApplication()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		// To log the name of the method
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("Information in @AfterReturning Advice: method name: "+ methodName);
		logger.info("Information: Data returned by method: "+ result);
	}
}

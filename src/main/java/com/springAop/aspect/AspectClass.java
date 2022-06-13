package com.springAop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/*
 * - The aspect class should be annotated as a @Configuration and @Aspect
 * - Pointcut indicates the method(s) that will be intercepted and Advice is a piece of code
 *   that will be executed upon the intercepted method(s).
 * - Aspect = Pointcut + advice
 * - Join point is a specific interception of the method called.
 * - weaving is the process of implementing the AOP around the intercepted method(s).
 * - weaver is the framework that ensures the execution of the advice at the specified pointcut.
 */

@Configuration
@Aspect
public class AspectClass {
	Logger logger = LoggerFactory.getLogger(getClass());
	/*
	 * Expressions for specifying pointcuts:
	 * 	- execution(return_type package_name.class_name.method_name(arguments))
	 *		-> specifies a group of methods that matches the specified signature.
	 *		ex: execution(* com.springAop.business.*.*(..)) -> any method in the package
	 *		com.springAop.business of any return type in any class will be intercepted
	 * 		regardless of its parameters.
	 *	- within(com.springAop.business..*)
	 *	- @annotation(com.springAop.aspect.TrackTime)
	 *	- bean(*dao*)
	 * 
	 */

	@Before("execution(* com.springAop.business.*.*(..))")
	public void before(JoinPoint joinPoint) {
		logger.info("Intercepted method calls {}", joinPoint);
	}
	
	@AfterReturning(value = "execution(* com.springAop.business.*.*(..))", returning = "ret_value")
	public void afterReturning(JoinPoint joinPoint, Object ret_value) {
		logger.info("after returning from '{}' we got value '{}'", joinPoint.getSignature(), ret_value);
	}

	@AfterThrowing(value = "execution(* com.springAop.business.*.*(..))", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Object exception) {
		logger.info("after returning from '{}' we got value '{}'", joinPoint.getSignature(), exception);
	}
	
	@After(value = "com.springAop.aspect.CommonJoinPointConfig.dataLayerExecution()")
	public void after(JoinPoint joinPoint) {
		logger.info("@After", joinPoint.getSignature());
	}
	
	@Around(value = "execution(* com.springAop.business.*.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		//logger.info("Time taken by {} is {}",joinPoint, timeTaken);
	}
	
	@Around(value = "com.springAop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
	public void trackTimeAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
		// tracking only the methods with the @TrackTime
		long startTime = System.currentTimeMillis();
		joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Time taken by {} is {}",joinPoint, timeTaken);
	}
}

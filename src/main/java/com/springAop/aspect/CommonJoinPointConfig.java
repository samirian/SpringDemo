package com.springAop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
	@Pointcut("execution(* com.springAop.business.*.*(..))")
	public void dataLayerExecution() {}
	
	@Pointcut("com.springAop.aspect.CommonJoinPointConfig.dataLayerExecution() && com.springAop.aspect.CommonJoinPointConfig.dataLayerExecution()")
	public void aMixOfTwo() {}
	
	@Pointcut("bean(*dao*)")
	public void byBeanName() {}

	@Pointcut("within(com.springAop.business..*)")
	public void allCallsInAPackage() {}
	
	@Pointcut("@annotation(com.springAop.aspect.TrackTime)")
	public void trackTimeAnnotation() {}
}

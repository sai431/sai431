package com.poc.springboot.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommmonJoinPoint {
	
	 @Pointcut("execution(* com.poc.springboot.Controller.*.*(..))")
	    public void businessLayerExecution() {}


}

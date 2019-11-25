package com.poc.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectWithLogger {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.poc.springboot.Controller.*.*(..))")
	public void before(JoinPoint joinPoint) {
		// Advice
		// logger.info(" Entering into getClass
		// "+joinPoint.getClass().getMethods().toString());
		logger.info(" Entering into Targeted classs " + joinPoint.getTarget().getClass().getCanonicalName()
				+ " And inside a target method   " + joinPoint.getSignature().getName().toString());
		//

	}

	@After(value = "execution(* com.poc.springboot.Controller.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info(" Exiting from  Targeted classs " + joinPoint.getTarget().getClass().getCanonicalName()
				+ "  And from a target method  " + joinPoint.getSignature().getName().toString());
	}

	/*
	 * @Around("com.poc.springboot.aop.CommmonJoinPoint.businessLayerExecution()")
	 * public void around(ProceedingJoinPoint joinPoint) throws Throwable { long
	 * startTime = System.currentTimeMillis();
	 * 
	 * joinPoint.proceed();//to execute method
	 * 
	 * long timeTaken = System.currentTimeMillis() - startTime;
	 * logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
	 * 	/*
		 * logger.info(" Entering into getArgs "+ joinPoint.getArgs());
		 * logger.info(" Entering into getThis "+ joinPoint.getThis());
		 * logger.info(" Entering into getKind "+ joinPoint.getKind());
		 * logger.info(" Entering into Signature "+
		 * joinPoint.getSignature().getName().toString());
		 * 
		 * logger.info(" Entering into StaticPart "+
		 * joinPoint.getStaticPart().toString());
		 */
		// logger.info(" Entering into SourceLocation
		// "+joinPoint.getSourceLocation().getLine());
		// Object[] signatureArgs = thisJoinPoint.getArgs();
		// for (Object signatureArg: signatureArgs) {
		// System.out.println("Arg: " + signatureArg);
		// ...
		// }
		///
	
	

	/*
	 * @After - Executed in two situations - when a method executes successfully or
	 * it throws an exception.
	 * 
	 * @AfterReturning - Executed only when a method executes successfully.
	 * 
	 * @AfterThrowing - Executed only when a method throws an exception.
	 * 
	 */

}

package ua.com.team.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declaration
	@Pointcut("execution(* ua.com.team.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	// do the same for service and dao
	@Pointcut("execution(* ua.com.team.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* ua.com.team.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlor() {
	}

	// add @Befor advice
	@Before("forAppFlor()")
	public void befor(JoinPoint theJoinPoint) {
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>>> in @Before: calling method: " + theMethod);

		// display the argument to the method

		// get the arguments
		Object[] args = theJoinPoint.getArgs();

		// loop thru and display args
		for (Object tempArg : args) {
			myLogger.info("=====>>> argument: " + tempArg);
		}

	}

	// add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlor()", returning = "theResult")
	private void afterReturning(JoinPoint theJoinPoint, Object theResult) {

		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>>> in @AfterReturning: from method: " + theMethod);

		// display data returning
		myLogger.info("=====>>> result: " + theResult);
	}
}

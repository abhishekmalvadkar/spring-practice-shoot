package in.spring.shoot.AOPAsyncAndSyncBehaviour;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
	
	private static final String METHOD_END_FORMAT = "{} >>>>>>>>>";
	private static final String METHOD_START_FORMAT = "<<<<<<<<< {}";

	@Before("@annotation(in.spring.shoot.AOPAsyncAndSyncBehaviour.LogMethodEntryExit)")
	public void beforeMethod(JoinPoint joinpoint) {
		String name = "rushikejs";
		log.info("from beforeMethod :: {}" , name);
		log.info("beforeMethod() method code is processed by thread :: {}" , Thread.currentThread().getName());
		Signature signature = joinpoint.getSignature();
		log.trace(METHOD_START_FORMAT , signature);
	}
	
	@AfterReturning("@annotation(in.spring.shoot.AOPAsyncAndSyncBehaviour.LogMethodEntryExit)")
	public void afterMethodSucess(JoinPoint joinpoint) {
		log.info("afterMethodSucess() method code is processed by thread :: {}" , Thread.currentThread().getName());
		Signature signature = joinpoint.getSignature();
		log.trace(METHOD_END_FORMAT , signature);
	}
	
	@After("@annotation(in.spring.shoot.AOPAsyncAndSyncBehaviour.LogMethodEntryExit)")
	public void afterMethodNormal(JoinPoint joinpoint) {
		log.info("afterMethodNormal() method code is processed by thread :: {}" , Thread.currentThread().getName());
		Signature signature = joinpoint.getSignature();
		log.trace(METHOD_END_FORMAT , signature);
	}
	
	@Around("@annotation(in.spring.shoot.AOPAsyncAndSyncBehaviour.CacheResponse)")
	public Object cacheResponse(ProceedingJoinPoint joinpoint) throws Throwable {
		log.info("cacheResponse() method code is processed by thread :: {}" , Thread.currentThread().getName());
		Signature signature = joinpoint.getSignature();
		log.trace(METHOD_START_FORMAT , signature);
		
		Object response = joinpoint.proceed();
		
		log.info("Storing response in redis");
		
		log.trace(METHOD_END_FORMAT , signature);
		
		return response;
		
		
	}

}

package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	
	public Object aroundLog(ProceedingJoinPoint pjp)  {
		
		System.out.println("[Before] : 비즈니스로직 실행전 처리");
		
		Object returnObj = null;
		try {
			returnObj = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("[after] : 비즈니스로직 실행후 처리");
		return returnObj;
	}

}

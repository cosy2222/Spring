package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	
	public Object aroundLog(ProceedingJoinPoint pjp)  {
		
		System.out.println("[Before] : ����Ͻ����� ������ ó��");
		
		Object returnObj = null;
		try {
			returnObj = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("[after] : ����Ͻ����� ������ ó��");
		return returnObj;
	}

}

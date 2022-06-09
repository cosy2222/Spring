package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice2 {
	//Around : 메소드실행 전후로 작동 하는 메소드 
		// 매개변수로 ProceedingJoinPoint
	// ProceedingJoinPoint는 인터페이스이고 JoinPoint 로 상속하고 있다 
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		
		String method = pjp.getSignature().getName();

		// 메소드 실행 시간을 출력
		StopWatch stopwatch = new StopWatch();
		System.out.println("[메소드 수행전]");
		stopwatch.start();
		
		//예외처리 필요
		Object obj = pjp.proceed();
		System.out.println("[메소드 수행후]");
		stopwatch.stop();
		
		System.out.print(method + "() 메소드 수행에 걸린 시간 :");
		System.out.println(stopwatch.getTotalTimeSeconds());
		
		return obj;
		
	}
}

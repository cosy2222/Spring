package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
	// AOP에서 정보를 출력하는 메소드가 저장된 인터페이스


public class BeforeAdvice2 {
	
	public void beforeLog(JoinPoint jp) {
		//처리하는 메소드 이름을 알아올 수 있다 
		String method = jp.getSignature().getName();
		
		// 메소드 호출에 어떤 값들을 사용했는지 알 수 있다
		// 메소드의 매개변수에 등록된 정보
		Object[] args = jp.getArgs();
		
		System.out.println("[사전처리]" + method + "() 메소드 정보" );
		System.out.println("[사전처리] ARGS정보 - " + args.toString());
		
		
	}

}

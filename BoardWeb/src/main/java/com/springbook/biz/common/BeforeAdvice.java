package com.springbook.biz.common;

public class BeforeAdvice {
	
	public void beforeLog() {
		System.out.println("[사전처리] 비즈니스 로직 수행전 실행");
	}

}

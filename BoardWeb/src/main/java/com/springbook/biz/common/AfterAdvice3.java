package com.springbook.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice3 {
	
	
	// 외부 포인트 컷
	
	@After("PointCutCommon.getPointCut()")
	public void afterLog() {
		System.out.println("[사후처리] 비즈니스 로직 수행후 실행");
	}
}

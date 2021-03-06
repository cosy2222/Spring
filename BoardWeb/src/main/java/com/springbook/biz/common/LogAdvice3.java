package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect					// Aspect = Pointcut + advice
public class LogAdvice3 {
	
	//////// 포인트컷 설정 : 적용할 메소드의 필터링 ///////////////////////
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointCut () {} // 포인트컷 이름만 적용하는 빈 메소드 생성
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointCut() {}
	
	
	/////////////////////// 2. 어드바이스 //////////////////////////////////
	@Before("allPointCut()")
	public void printLog() {
		System.out.println("[공통로그] 비즈니스 로직 수행전 동작 (어노테이션을 통한 구동)");
	}

}

package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice3 {
	// AfterThrowing : 핵심 로직에서 예외가 발생 되었을떄 처리되는 Advice 
	// Exception ExceptionOjb : AOP의 바인드 변수
	
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointCut () {} // 포인트컷 이름만 적용하는 빈 메소드 생성
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointCut() {}
	
	
	@AfterThrowing(pointcut = "allPointCut()" , throwing = "exceptionObj")
	public void exceptionLog(JoinPoint jp , Exception exceptionObj) {
		
		String method = jp.getSignature().getName();
		
		if (exceptionObj instanceof IllegalArgumentException) {
			System.out.println("부적절한 값이 입력됨");
		}else if(exceptionObj instanceof NumberFormatException) {
			System.out.println("숫자형식의 값이 아닙니다");
		}else if(exceptionObj instanceof Exception) {
			System.out.println("문제 발생");
		}
		
		System.out.println("[예외처리 - 어노테이션] " + method + "()메소드 수행중 오류 발생");
		System.out.println("[예외처리 - 어노테이션] 예외메세지 : " + exceptionObj.getMessage() );
		
	}

}

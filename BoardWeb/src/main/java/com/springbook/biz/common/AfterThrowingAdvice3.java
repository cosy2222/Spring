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
	// AfterThrowing : �ٽ� �������� ���ܰ� �߻� �Ǿ����� ó���Ǵ� Advice 
	// Exception ExceptionOjb : AOP�� ���ε� ����
	
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointCut () {} // ����Ʈ�� �̸��� �����ϴ� �� �޼ҵ� ����
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointCut() {}
	
	
	@AfterThrowing(pointcut = "allPointCut()" , throwing = "exceptionObj")
	public void exceptionLog(JoinPoint jp , Exception exceptionObj) {
		
		String method = jp.getSignature().getName();
		
		if (exceptionObj instanceof IllegalArgumentException) {
			System.out.println("�������� ���� �Էµ�");
		}else if(exceptionObj instanceof NumberFormatException) {
			System.out.println("���������� ���� �ƴմϴ�");
		}else if(exceptionObj instanceof Exception) {
			System.out.println("���� �߻�");
		}
		
		System.out.println("[����ó�� - ������̼�] " + method + "()�޼ҵ� ������ ���� �߻�");
		System.out.println("[����ó�� - ������̼�] ���ܸ޼��� : " + exceptionObj.getMessage() );
		
	}

}

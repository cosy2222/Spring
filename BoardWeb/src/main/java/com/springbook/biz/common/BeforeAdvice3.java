package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice3 {
	
	////// 1. ����Ʈ �� ���� //////////////////
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointCut () {} // ����Ʈ�� �̸��� �����ϴ� �� �޼ҵ� ����
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointCut() {}
	
	
	/////// 2. Advice �޼ҵ� : ��� ���͸��� �޼ҵ忡 ����Ǵ� �޼ҵ� /////////////////
	@Before("allPointCut()")
	public void beforeLog(JoinPoint jp) {
		//ó���ϴ� �޼ҵ� �̸��� �˾ƿ� �� �ִ� 
		String method = jp.getSignature().getName();
		
		// �޼ҵ� ȣ�⿡ � ������ ����ߴ��� �� �� �ִ�
		// �޼ҵ��� �Ű������� ��ϵ� ����
		Object[] args = jp.getArgs();
		
		System.out.println("[����ó�� - ������̼� ����]" + method + "() �޼ҵ� ����" );
		System.out.println("[����ó�� - ������̼� ����] ARGS���� - " + args.toString());
		
		
	}

}

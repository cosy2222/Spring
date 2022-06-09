package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
	// AOP���� ������ ����ϴ� �޼ҵ尡 ����� �������̽�


public class BeforeAdvice2 {
	
	public void beforeLog(JoinPoint jp) {
		//ó���ϴ� �޼ҵ� �̸��� �˾ƿ� �� �ִ� 
		String method = jp.getSignature().getName();
		
		// �޼ҵ� ȣ�⿡ � ������ ����ߴ��� �� �� �ִ�
		// �޼ҵ��� �Ű������� ��ϵ� ����
		Object[] args = jp.getArgs();
		
		System.out.println("[����ó��]" + method + "() �޼ҵ� ����" );
		System.out.println("[����ó��] ARGS���� - " + args.toString());
		
		
	}

}

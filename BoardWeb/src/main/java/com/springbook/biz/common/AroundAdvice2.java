package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice2 {
	//Around : �޼ҵ���� ���ķ� �۵� �ϴ� �޼ҵ� 
		// �Ű������� ProceedingJoinPoint
	// ProceedingJoinPoint�� �������̽��̰� JoinPoint �� ����ϰ� �ִ� 
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		
		String method = pjp.getSignature().getName();

		// �޼ҵ� ���� �ð��� ���
		StopWatch stopwatch = new StopWatch();
		System.out.println("[�޼ҵ� ������]");
		stopwatch.start();
		
		//����ó�� �ʿ�
		Object obj = pjp.proceed();
		System.out.println("[�޼ҵ� ������]");
		stopwatch.stop();
		
		System.out.print(method + "() �޼ҵ� ���࿡ �ɸ� �ð� :");
		System.out.println(stopwatch.getTotalTimeSeconds());
		
		return obj;
		
	}
}

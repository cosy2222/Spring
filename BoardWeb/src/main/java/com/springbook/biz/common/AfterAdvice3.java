package com.springbook.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice3 {
	
	
	// �ܺ� ����Ʈ ��
	
	@After("PointCutCommon.getPointCut()")
	public void afterLog() {
		System.out.println("[����ó��] ����Ͻ� ���� ������ ����");
	}
}

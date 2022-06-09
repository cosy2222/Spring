package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service
@Aspect
public class AfterReturning3 {
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointCut () {} // ����Ʈ�� �̸��� �����ϴ� �� �޼ҵ� ����
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointCut() {}
	
	
	@AfterReturning(pointcut = "allPointCut()" , returning = "returnObj")
	public void afterReturningLog(JoinPoint jp , Object returnObj) {
		
		
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("admin")) {
				System.out.println(user.getName() + " �α���(admin)");
			}
		}
		System.out.println("[����ó�� - ������̼�] �޼ҵ� ��" + method );
		System.out.println("[����ó�� - ������̼�] �޼ҵ� ���ϰ�" + returnObj.toString() );
			
		
		
	}

}

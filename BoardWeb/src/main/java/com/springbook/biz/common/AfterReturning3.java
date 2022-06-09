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
	public void allPointCut () {} // 포인트컷 이름만 적용하는 빈 메소드 생성
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointCut() {}
	
	
	@AfterReturning(pointcut = "allPointCut()" , returning = "returnObj")
	public void afterReturningLog(JoinPoint jp , Object returnObj) {
		
		
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("admin")) {
				System.out.println(user.getName() + " 로그인(admin)");
			}
		}
		System.out.println("[사후처리 - 어노테이션] 메소드 명" + method );
		System.out.println("[사후처리 - 어노테이션] 메소드 리턴값" + returnObj.toString() );
			
		
		
	}

}

package com.springbook.biz.impl_user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		
		// 1. Spring 컨테이너 구동
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로 부터 UserServiceImpl 객체를 Lookup (가져온다)
		UserService userService = (UserService)container.getBean("UserService");
		
		// 3. 로그인 테스트 
		UserVO vo = new UserVO();
		vo.setId("admin");
		vo.setPassword("1234");
		
		UserVO user = userService.getuser(vo);
		
		if (user != null) {
			System.out.println(user.getName() + "님 ㅎㅇ");
			System.out.println("리턴 받아온 DB에 저장된 ID : " + user.getId());
			System.out.println("리턴 받아온 DB에 저장된 password : " + user.getPassword());
			System.out.println("리턴 받아온 DB에 저장된 name : " + user.getName());
			System.out.println("리턴 받아온 DB에 저장된 role : " + user.getRole());
			
		}else {
			System.out.println("로그인 실패");
		}
		
		// 3-2 insert
		vo.setId("test20");
		vo.setPassword("3456");
		vo.setName("테스트");
		vo.setRole("test");
		
		userService.insertUser(vo);
		
		//4. spring 컨테이너 종료
		container.close();
	}

}

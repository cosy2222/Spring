package com.springbook.biz.impl_user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		
		// 1. Spring �����̳� ����
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷ� ���� UserServiceImpl ��ü�� Lookup (�����´�)
		UserService userService = (UserService)container.getBean("UserService");
		
		// 3. �α��� �׽�Ʈ 
		UserVO vo = new UserVO();
		vo.setId("admin");
		vo.setPassword("1234");
		
		UserVO user = userService.getuser(vo);
		
		if (user != null) {
			System.out.println(user.getName() + "�� ����");
			System.out.println("���� �޾ƿ� DB�� ����� ID : " + user.getId());
			System.out.println("���� �޾ƿ� DB�� ����� password : " + user.getPassword());
			System.out.println("���� �޾ƿ� DB�� ����� name : " + user.getName());
			System.out.println("���� �޾ƿ� DB�� ����� role : " + user.getRole());
			
		}else {
			System.out.println("�α��� ����");
		}
		
		// 3-2 insert
		vo.setId("test20");
		vo.setPassword("3456");
		vo.setName("�׽�Ʈ");
		vo.setRole("test");
		
		userService.insertUser(vo);
		
		//4. spring �����̳� ����
		container.close();
	}

}

package com.springbook.biz.impl_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService{
	
	// 객체 주입 ( DI ) 
		// 1. 생성자를 통한 주입		( xml 설정 )
		// 2. setter 주입 		( xml 설정 ) 
		// 3. 어노테이션을 이용한 주입 ( @Autowired )

	@Autowired		//객체 주입 (타입으로 주입) , 어노테이션으로 객체 주입
	private  UserDAO dao ;
	
//	// setter 를 사용해서 객체 주입 ( xml 설정)
//	public void setUserDAO(UserDAO dao) {
//		
//		this.dao = dao;
//		
//	}
//	
//	// 생성자를 이용한 객체 주입 ( xml 설정)
//	public UserServiceImpl(UserDAO dao) {
//		this.dao = dao;
//	}
	
	
	
	
	@Override
	public UserVO getuser(UserVO vo) {
		return dao.getuser(vo);
	}

	@Override
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}


}

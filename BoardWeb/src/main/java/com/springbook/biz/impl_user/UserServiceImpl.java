package com.springbook.biz.impl_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService{
	
	// ��ü ���� ( DI ) 
		// 1. �����ڸ� ���� ����		( xml ���� )
		// 2. setter ���� 		( xml ���� ) 
		// 3. ������̼��� �̿��� ���� ( @Autowired )

	@Autowired		//��ü ���� (Ÿ������ ����) , ������̼����� ��ü ����
	private  UserDAO dao ;
	
//	// setter �� ����ؼ� ��ü ���� ( xml ����)
//	public void setUserDAO(UserDAO dao) {
//		
//		this.dao = dao;
//		
//	}
//	
//	// �����ڸ� �̿��� ��ü ���� ( xml ����)
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

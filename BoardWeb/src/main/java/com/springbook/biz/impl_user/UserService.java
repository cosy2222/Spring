package com.springbook.biz.impl_user;


import com.springbook.biz.user.UserVO;

public interface UserService {

	// 회원정보 검색 ( ID와 Password 를 매개변수로 받음 )
	UserVO getuser(UserVO vo);
	
	void insertUser(UserVO vo);

}
package com.springbook.biz.impl_user;


import com.springbook.biz.user.UserVO;

public interface UserService {

	// ȸ������ �˻� ( ID�� Password �� �Ű������� ���� )
	UserVO getuser(UserVO vo);
	
	void insertUser(UserVO vo);

}
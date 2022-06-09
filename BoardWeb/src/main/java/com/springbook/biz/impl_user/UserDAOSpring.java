package com.springbook.biz.impl_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository("UserDAOSpring")
public class UserDAOSpring {
	
	@Autowired     
	private JdbcTemplate JdbcTemplate;
	
	private String USER_GET = "select * from users where id = ? and password = ?";
	
	private String USER_INSERT = "insert into users values ( ? , ? , ? ,?)";
	
	public UserVO getuser(UserVO vo) {
		Object[] args = { vo.getId() , vo.getPassword()}; 
		return JdbcTemplate.queryForObject(USER_GET, args ,new UserRowMapper());
	}
	
	public void insertUser(UserVO vo) {
		System.out.println("user¿¡ insert");
		JdbcTemplate.update(USER_INSERT , vo.getId() , vo.getPassword() 
						     , vo.getName() , vo.getRole());
	}

	
	
	
	
	
	
	
	
	
	
}

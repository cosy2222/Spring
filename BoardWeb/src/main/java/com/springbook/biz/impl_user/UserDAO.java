package com.springbook.biz.impl_user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository("userDAO")    // UserDAO 클래스를 객체화  객체이름 = userDAO
public class UserDAO  {
	
	// 1. JDBC 관련 변수 선언 ( conn , pstmt , rs )
	private Connection conn = null;
	private PreparedStatement pstmt = null ; 
	private ResultSet rs = null ;
	
	// 2. SQL 상수 구문 적용.
	private String USER_GET = "select * from users where id = ? and password = ?";
	
	private String USER_INSERT = "insert into users values ( ? , ? , ? ,?)";
	
	
	// 3. CRUD 기능의 메소드 구현
	
		// 회원정보 검색 ( ID와 Password 를 매개변수로 받음 )
		public UserVO getuser(UserVO vo) {
			UserVO user = null;
			
			try {
				
				System.out.println("==> JDBC로 getuser() 처리");
				conn = JDBCUtil.getConnection();
				pstmt = conn.prepareStatement(USER_GET);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPassword());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
					user = new UserVO();
					user.setId(rs.getString("id"));
					user.setPassword(rs.getString("password"));
					user.setName(rs.getString("name"));
					user.setRole(rs.getString("role"));
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(rs, pstmt, conn);
			}
			
			return user;
		}
		
		
		
		// insert
		public void insertUser(UserVO vo) {
			
			System.out.println("user에 값 insert");
			
			try {
				conn = JDBCUtil.getConnection();
				pstmt = conn.prepareStatement(USER_INSERT);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPassword());
				pstmt.setString(3, vo.getName());
				pstmt.setString(4, vo.getRole());
				pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(pstmt, conn);
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}

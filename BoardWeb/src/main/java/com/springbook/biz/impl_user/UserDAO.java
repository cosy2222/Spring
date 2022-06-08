package com.springbook.biz.impl_user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository("userDAO")    // UserDAO Ŭ������ ��üȭ  ��ü�̸� = userDAO
public class UserDAO  {
	
	// 1. JDBC ���� ���� ���� ( conn , pstmt , rs )
	private Connection conn = null;
	private PreparedStatement pstmt = null ; 
	private ResultSet rs = null ;
	
	// 2. SQL ��� ���� ����.
	private String USER_GET = "select * from users where id = ? and password = ?";
	
	private String USER_INSERT = "insert into users values ( ? , ? , ? ,?)";
	
	
	// 3. CRUD ����� �޼ҵ� ����
	
		// ȸ������ �˻� ( ID�� Password �� �Ű������� ���� )
		public UserVO getuser(UserVO vo) {
			UserVO user = null;
			
			try {
				
				System.out.println("==> JDBC�� getuser() ó��");
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
			
			System.out.println("user�� �� insert");
			
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

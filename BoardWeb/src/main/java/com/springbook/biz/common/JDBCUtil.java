package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

public class JDBCUtil {

	//�޼ҵ� ȣ��� Connection ��ü�� �����ؼ� ���� ������
	public static Connection getConnection() {
		
		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa" , "");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//��ü ����� ȣ�� �޼ҵ�  : insert , update ,delete
	public static void close(PreparedStatement pstmt , Connection conn) {
		
		if(pstmt != null) {     // psmt ��ü ����
			
			try {
				if(!pstmt.isClosed()) {
					pstmt.close();
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				pstmt = null;
			}
		}
		
		
		if(conn != null) {	//conn ��ü ����
			
			try {
				
				if(!conn.isClosed()) {
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
			
		}
		
	}
	
	
	//��ü ���� ( ResultSet , PreparedStatement , Connection ) : select 
	public static void close(ResultSet rs , PreparedStatement pstmt , Connection conn)  {
		if (rs != null) {
			try {
				
				if(!rs.isClosed()) {
					rs.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				rs = null;
			}
			close(pstmt ,conn);
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.springbook.biz.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springbook.biz.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO> {
	
	//DB에서 Select 한 결과를 BoardVO에 저장해서 값을 처리 (JDBC 템플릿에서 사용함) 

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content")); 
		board.setRegdate(rs.getDate("regdate")); 
		board.setCnt(rs.getInt("cnt")); 

		return board; 
		
		
	}

}

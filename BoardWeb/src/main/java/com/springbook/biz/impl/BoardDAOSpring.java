package com.springbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.BoardVO;

@Repository("BoardDAOSpring")
public class BoardDAOSpring {
	
	//Spring  에서는 Connection객체 , Statement , PreparedStatement , ResultSet 
		// 선언하지 않고 사용하지 않는다  대신에 jdbcTemplate 를 사용해서 처리
	// jdbaTemplate를 사용하면 코드가 간단하고 깔끔해진다
	
	// Insert , Update , Delete
		// jdbcTemplate.update ( SQL구문 , ? ,? ,? );
	
	// select 
		// 1. 단일 레코드 출력 (상세내용)
			// jdbcTemplate.queryForObject(SQL 구문 , ? , ? , new RowMapper 인터페이스를 구현한 객체로전달)
		// 2. 여러개의 레코드 출력 (리스트)
			// jdbcTemplate.query(SQL 구문 , ? , ? , new RowMapper인터페이스를 구현한 객체로 전달)
	
	
	@Autowired     // JDBCTemplate 객체 활성화
	private JdbcTemplate JdbcTemplate;
	
	
	// 2. SQL 쿼리 정의 (상수로 선언)
	
		
		// 트랜잭션 작동 실습시 임시로 구현
//		private final String BOARD_INSERT = "insert into board (seq , title , writer , content)"
//		+"values( ? , ? , ? ,?)";
	
	
		private final String BOARD_INSERT = "insert into board (seq , title , writer , content)"
								+"values( (select nvl(max(seq) , 0)+1 from board) , ? , ? ,?)";
		
		private final String BOARD_UPDATE = "update board set title = ? , content = ? "
									+ "where seq = ?";
		
		private final String BOARD_DELETE = "delete board where seq = ?";
		
		private final String BOARD_GET = "select * from board where seq = ?";
		
		private final String BOARD_LIST = "select * from board order by seq desc";
		

		
		// CRUD 기능 구현
		
		// 1. 글 등록
		public void insertBoard(BoardVO vo) { 
			System.out.println("===> JDBC로 insertBoard() 기능 처리"); 
			JdbcTemplate.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent()); 
		} 
		
		// 2. 글 수정
		public void updateBoard(BoardVO vo) { 
			System.out.println("===> JDBC로 updateBoard() 기능 처리"); 
			JdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq()); 
		} 
		
		// 3. 글 삭제
		public void deleteBoard(BoardVO vo) { 
			System.out.println("===> JDBC로 deleteBoard() 기능 처리"); 
			JdbcTemplate.update(BOARD_DELETE, vo.getSeq()); 
		} 
		
		// 4. 글 상세조회
		public BoardVO getBoard(BoardVO vo) { 
			System.out.println("===> JDBC로 getBoard() 기능 처리"); 
			Object[] args = { vo.getSeq() }; 
			return JdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper()); 
		} 
		
		// 5. 글 목록 조회 
		public List<BoardVO> getBoardList(BoardVO vo) { 
			System.out.println("===> JDBC로 getBoardList()기능 처리"); 
			return JdbcTemplate.query(BOARD_LIST, new BoardRowMapper()); 
		} 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}

package com.springbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.BoardVO;

@Repository("BoardDAOSpring")
public class BoardDAOSpring {
	
	//Spring  ������ Connection��ü , Statement , PreparedStatement , ResultSet 
		// �������� �ʰ� ������� �ʴ´�  ��ſ� jdbcTemplate �� ����ؼ� ó��
	// jdbaTemplate�� ����ϸ� �ڵ尡 �����ϰ� ���������
	
	// Insert , Update , Delete
		// jdbcTemplate.update ( SQL���� , ? ,? ,? );
	
	// select 
		// 1. ���� ���ڵ� ��� (�󼼳���)
			// jdbcTemplate.queryForObject(SQL ���� , ? , ? , new RowMapper �������̽��� ������ ��ü������)
		// 2. �������� ���ڵ� ��� (����Ʈ)
			// jdbcTemplate.query(SQL ���� , ? , ? , new RowMapper�������̽��� ������ ��ü�� ����)
	
	
	@Autowired     // JDBCTemplate ��ü Ȱ��ȭ
	private JdbcTemplate JdbcTemplate;
	
	
	// 2. SQL ���� ���� (����� ����)
	
		
		// Ʈ����� �۵� �ǽ��� �ӽ÷� ����
//		private final String BOARD_INSERT = "insert into board (seq , title , writer , content)"
//		+"values( ? , ? , ? ,?)";
	
	
		private final String BOARD_INSERT = "insert into board (seq , title , writer , content)"
								+"values( (select nvl(max(seq) , 0)+1 from board) , ? , ? ,?)";
		
		private final String BOARD_UPDATE = "update board set title = ? , content = ? "
									+ "where seq = ?";
		
		private final String BOARD_DELETE = "delete board where seq = ?";
		
		private final String BOARD_GET = "select * from board where seq = ?";
		
		private final String BOARD_LIST = "select * from board order by seq desc";
		

		
		// CRUD ��� ����
		
		// 1. �� ���
		public void insertBoard(BoardVO vo) { 
			System.out.println("===> JDBC�� insertBoard() ��� ó��"); 
			JdbcTemplate.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent()); 
		} 
		
		// 2. �� ����
		public void updateBoard(BoardVO vo) { 
			System.out.println("===> JDBC�� updateBoard() ��� ó��"); 
			JdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq()); 
		} 
		
		// 3. �� ����
		public void deleteBoard(BoardVO vo) { 
			System.out.println("===> JDBC�� deleteBoard() ��� ó��"); 
			JdbcTemplate.update(BOARD_DELETE, vo.getSeq()); 
		} 
		
		// 4. �� ����ȸ
		public BoardVO getBoard(BoardVO vo) { 
			System.out.println("===> JDBC�� getBoard() ��� ó��"); 
			Object[] args = { vo.getSeq() }; 
			return JdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper()); 
		} 
		
		// 5. �� ��� ��ȸ 
		public List<BoardVO> getBoardList(BoardVO vo) { 
			System.out.println("===> JDBC�� getBoardList()��� ó��"); 
			return JdbcTemplate.query(BOARD_LIST, new BoardRowMapper()); 
		} 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}

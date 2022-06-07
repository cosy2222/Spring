package com.springbook.biz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.BoardVO;
import com.springbook.biz.common.JDBCUtil;

// Bean 등록 : 어노테이션 기반 빈등록.  @Component
@Repository("boardDAO")
public class BoardDAO  {
	
	// 1. JDBC 관련 변수 선언 
	private Connection conn = null ;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null ; 
	
	// 2. SQL 쿼리 정의 (상수로 선언)
	private final String BOARD_INSERT = "insert into board (seq , title , writer , content)"
							+"values( (select nvl(max(seq) , 0)+1 from board) , ? , ? ,?)";
	
	private final String BOARD_UPDATE = "update board set title = ? , content = ? "
								+ "where seq = ?";
	
	private final String BOARD_DELETE = "delete board where seq = ?";
	
	private final String BOARD_GET = "select * from board where seq = ?";
	
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	private final String BOARD_LIST_T = "select * from board where title like '%' || ? || '%' "
								+ " order by seq desc";   // 글 제목으로 검색 쿼리 
	
	private final String BOARD_LIST_C = "select * from board where content like '%' || ? || '%'"
								+ " order by seq desc";	  // 글 내용으로 검색 쿼리 
	
	// CRUD를 구현하는 메소드 정의
	// 3. insert 메소드 정의
	public void insertBoard(BoardVO vo ) {
		System.out.println("==> JDBC로 insertBoard() 기능처리됨");
		
		try {
			
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			
			System.out.println("insert 성공");
			
		}catch(Exception e ) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);  // 객체 제거 메소드 
		}
		
	}
	
	
	// 4. update 메소드 정의 
	public void updateBoard(BoardVO vo) {
		System.out.println(" ==> JDBC로 updateBoard() 기능 처리됨");
		
		try {
			
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());
			pstmt.executeUpdate();
			System.out.println("글수정 성공");
			
			
		}catch(Exception e) {
			
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	// 5. Delete 메소드 정의
	public void deleteBoard(BoardVO vo) {
		System.out.println("==> JDBC로 deleteBoard() 기능 처리됨");
		
		try {
			
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
			System.out.println("글삭제 성공");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	
	
	// 6. Select 메소드 정의 (상세내용) (글 상세 조회)
	public BoardVO getBoard (BoardVO vo) {
		System.out.println("==> JDBC로 getBoard() 기능 처리됨");
		BoardVO board = null;
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());
			rs= pstmt.executeQuery();
			
			if(rs.next()) {  // select 한 결과같이 존재한다면 , rs의 값을 board에 setter주입
				
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return board;
	}
	
	// 7. Select 메소드 정의 (List)
	public List<BoardVO> getBoardList(BoardVO vo){
		List<BoardVO> boardList = new ArrayList<BoardVO>() ;
		
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {  //DB에서 select 한 결과 값을 vo에 담는다 
								// 각각의 vo객체를 ArrayList에 저장해서 리턴
				
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				
				boardList.add(board);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		
		
		
		return boardList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

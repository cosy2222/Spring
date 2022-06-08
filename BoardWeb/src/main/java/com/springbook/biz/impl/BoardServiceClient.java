package com.springbook.biz.impl;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.BoardVO;

public class BoardServiceClient {
	
	public static void main(String[] args) {
		// 1. Spring �����̳ʸ� �۵� ��Ų�� 
		AbstractApplicationContext container = 
					new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷ� ���� BoardServiceImpl ��ü�� �޾ƿ´� (LookUp �Ѵ�)
				// ����Ͻ� ������ ó���ϴ� ��ü (BoardServiceImpl.java)
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. �� ��� ����׽�Ʈ
		BoardVO vo = new BoardVO();
		vo.setTitle("�׽�Ʈ ����11");
		vo.setWriter("������");
		vo.setContent("�׽�Ʈ ����");
		
		boardService.insertBoard(vo);
		
		// 4. �� ��� �˻� ��� �׽�Ʈ
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		for(BoardVO board : boardList) {
			System.out.println("----���----->" + board.toString());
		}
		
		// 5. Spring �����̳� ���� 
		container.close();
	}

}
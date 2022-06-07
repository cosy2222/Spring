package com.springbook.biz.impl;

import java.util.List;

import com.springbook.biz.BoardVO;

public interface BoardService {  // �������̽��� ��üȭ �Ұ���

	// CRUD�� �����ϴ� �޼ҵ� ����
	// 3. insert �޼ҵ� ����
	void insertBoard(BoardVO vo);

	// 4. update �޼ҵ� ���� 
	void updateBoard(BoardVO vo);

	// 5. Delete �޼ҵ� ����
	void deleteBoard(BoardVO vo);

	// 6. Select �޼ҵ� ���� (�󼼳���) (�� �� ��ȸ)
	BoardVO getBoard(BoardVO vo);

	// 7. Select �޼ҵ� ���� (List)
	List<BoardVO> getBoardList(BoardVO vo);

}
package com.springbook.biz.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class UpdateBoardController  {

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo , BoardDAO boardDAO) {
		System.out.println("�� ���� ó�� - Spring MVC ȣ�� - Controller �и�");
		
		 boardDAO.updateBoard(vo);
		 
		 ModelAndView mav = new ModelAndView();
		 
		 return "redirect:getBoardList.do";
	
	}

}

package com.springbook.biz.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController  {

	@RequestMapping("/login.do")
	public String login(UserVO vo , UserDAO userDAO ) {
		System.out.println("로그인 처리 - Spring MVC 호출 - Controller 분리");
		
		System.out.println("id" + vo.getId());
		System.out.println("password" + vo.getPassword());
		
		if(userDAO.getUser(vo) != null) {	// DB에서 해당 레코드가 존재
			return "redirect:getBoardList.do";
		}else {		
			return "redirect:login:jsp";
		}
					
		
	}

}

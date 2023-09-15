package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 *  @RequestMapping 클래스 + 메서드 매핑.
 *  
 *  강추! 이방식으로 스프링 컨트롤러 사용하기.!!
 */

@RequestMapping("/user")
@Controller
public class UserController {
	
	@RequestMapping("/joinform")
	public String joinform() {
		return "/WEB-INF/views/joinform.jsp";
		
	}
}

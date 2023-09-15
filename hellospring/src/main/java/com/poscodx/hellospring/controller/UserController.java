package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/*
 *  @RequestMapping 클래스 + 메서드 매핑.
 *  
 *  강추! 이방식으로 스프링 컨트롤러 사용하기.!!
 */

@RequestMapping("/user")
@Controller
public class UserController {
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";	
	}
	
	// 객체일때는클래스 객체 필드변수에 저장.,
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo vo) {
		System.out.println("UserController.join(): UserDao.insert("+vo+")");
		return "redirect:/";
	}
	
	// /hellospring/user/update?n=kim
	// n으로 넘어오는 변수를 name에 저장. 같은경우 생략가능.
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		
		return "UserController.update("+ name +") ";
		
	}
	
	//입력 값이 없을때는 디폴트값 설정.
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value = "n", required=true, defaultValue="") String name) {
		return "UserController.update2("+ name +") ";
	}
	
	// /board/list?p=1;
	@ResponseBody
	@RequestMapping("/list")
	public String list(@RequestParam(value = "n", required=true, defaultValue="1") int pageNo) {
		return "UserController.list("+ pageNo +") ";
	}
	
	
	
}

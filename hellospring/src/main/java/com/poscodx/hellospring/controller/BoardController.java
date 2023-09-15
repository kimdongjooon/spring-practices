package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping 메소드 단독 매핑.
 *
 */

@Controller
public class BoardController {
	
	@ResponseBody
	@RequestMapping("/board/write")
	public String write() {
		return "BoardController.write()";
	}
	
	// /board/view/10
	@ResponseBody
	@RequestMapping("/board/view1/{no}")
	public String view1(@PathVariable("no") Long no) {
		return "BoardController.view("+no+")";		
	}
	
	// board/view2?no=10
	@ResponseBody
	@RequestMapping("/board/view2")
	public String view2(Long no) {
		return "BoardController.view("+no+")";		
	}
}

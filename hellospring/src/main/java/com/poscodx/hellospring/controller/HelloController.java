package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public String hello2(String name, int no) {
		System.out.println(no+":"+name);
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(String n) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		mav.addObject("name",n);
		
		return mav;
	}
	
	@RequestMapping("/hello4")
	public String hello4 (String n, Model model) {
		model.addAttribute("name",n);
		return "/WEB-INF/views/hello3.jsp";
	}
	@ResponseBody
	@RequestMapping("/hello5")
	public String hello5() {
		return "<h1>Hello5 Spring</h1>";
	}
	
	
}

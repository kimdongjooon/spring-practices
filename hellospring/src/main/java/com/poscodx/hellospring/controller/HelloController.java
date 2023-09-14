package com.poscodx.hellospring.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		return "<h1>Hello5 Spring 안녕.</h1>";
	}
	
	// 리다이렉트. 내가 작성한 mapping url만 작성가능. 
	@RequestMapping("/hello6")
	public String hello6() {
		return "redirect:/hello";
	}
	
	// 스프링 쓰는데 굳이 servlet기술 사용할 필요없음. 사용은 가능함.
	@RequestMapping("/hello7")
	public void hello7(
			HttpServletRequest request,
			HttpServletResponse response,
			Writer out) throws IOException{
		
		String name = request.getParameter("n");
		out.write("hello " + name);
		
	}
	
	
}

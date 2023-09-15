package com.poscodx.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poscodx.emaillist.repository.EmaillistRepository;
import com.poscodx.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	@Autowired
	private EmaillistRepository emaillistRepository;
	
//	@ResponseBody  // 웹 요청 받은곳을 응답. html 바디를 생성하겠다.의미. 
	@RequestMapping ("/")
	public String main(Model model) {
		List<EmaillistVo> list = emaillistRepository.findAll();
		model.addAttribute("list",list);
		return "main"; //"/WEB-INF/views/main.jsp" 를 viewresovler가해줌.
	}
	

	@RequestMapping (value = "/add", method=RequestMethod.GET)
	public String add() {
		return "add";
	}
	
	@RequestMapping (value = "/add", method=RequestMethod.POST)
	public String add(EmaillistVo vo) {
		// 한글 
		
		emaillistRepository.insert(vo);
		return "redirect:/";
	}
}

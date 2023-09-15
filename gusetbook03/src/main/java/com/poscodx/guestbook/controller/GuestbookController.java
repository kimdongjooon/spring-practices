package com.poscodx.guestbook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poscodx.guestbook.repository.GuestBookRepository;
import com.poscodx.guestbook.vo.GuestBookVo;

@Controller
public class GuestbookController {
	private GuestBookRepository guestbookRepository = new GuestBookRepository();
	
	@RequestMapping("/")
	public String main(Model model) {
		List<GuestBookVo> list = guestbookRepository.findAll();
		model.addAttribute("list",list);
		return "main";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String add() {
		return "add";
		
	}
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String add(GuestBookVo vo) {
		guestbookRepository.insert(vo);
		
		return "redirect:/";
	}
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(@PathVariable("no") int no, Model model) {
		model.addAttribute("no",no);
		
		return "deleteform";
	}
	
	@RequestMapping(value = "/delete/{no}", method=RequestMethod.POST)
	public String delete(@PathVariable("no") int no, GuestBookVo vo) {
    	new GuestBookRepository().deleteById(no, vo.getPassword());
    	
		return "redirect:/";
	}
	
	
	
	
}

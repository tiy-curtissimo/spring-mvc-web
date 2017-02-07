package com.theironyard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.theironyard.services.PersonDao;

@Controller
public class IndexController {
	private PersonDao dao;
	
	public IndexController(PersonDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "I am having a great day!");
		model.addAttribute("home", "http://curtis.schlak.com");
		model.addAttribute("people", dao.getPeople());
		return "index";
	}
}












package com.theironyard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.theironyard.services.PersonDao;
import com.theironyard.services.ProductDao;

@Controller
public class IndexController {
	private PersonDao peopleDao;
	private ProductDao productsDao;
	
	public IndexController(PersonDao peopleDao, ProductDao productsDao) {
		this.peopleDao = peopleDao;
		this.productsDao = productsDao;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("people", peopleDao.getPeople());
		model.addAttribute("products", productsDao.getProducts());
		return "index";
	}
}












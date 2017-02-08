package com.theironyard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.theironyard.services.PersonDao;
import com.theironyard.services.ProductsDao;

@Controller
public class IndexController {
	private PersonDao peopleDao;
	private ProductsDao productsDao;
	
	public IndexController(PersonDao peopleDao, ProductsDao productsDao) {
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












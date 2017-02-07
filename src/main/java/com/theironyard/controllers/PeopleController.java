package com.theironyard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.theironyard.models.Person;
import com.theironyard.services.PersonDao;

@Controller
@RequestMapping("/people")
public class PeopleController {
	private PersonDao dao;
	
	public PeopleController(PersonDao dao) {
		 this.dao = dao;
	}
	
	@RequestMapping("/new")
	public String newish() {
		return "people/new";
	}
	
	// POST /people/{id}
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String update(Person person) {
		dao.update(person);
		return "redirect:/people/" + person.getId();
	}
	
	// GET /people/{id}/edit
	@RequestMapping(value="/{id}/edit")
	public String edit(Model model, @PathVariable Integer id) {
		Person person = dao.get(id);
		model.addAttribute("person", person);
		return "people/edit";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(Person person) {
		person = dao.insert(person);
		return "redirect:/people/" + person.getId();
	}
	
	@RequestMapping("/{id}")
	public String details(Model model, @PathVariable Integer id) {
		Person person = dao.get(id);
		model.addAttribute("person", person);
		return "people/details";
	}
}

















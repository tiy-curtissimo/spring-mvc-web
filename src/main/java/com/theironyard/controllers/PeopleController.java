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
	
	@RequestMapping("")
	public String list(Model model) {
		model.addAttribute("people", dao.getPeople());
		return "people/list";
	}
	
	@RequestMapping("/new")
	public String newish(Model model) {
		model.addAttribute("person", new Person());
		return "people/new";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String update(Person person) {
		dao.update(person);
		return "redirect:/people";
	}
	
	@RequestMapping(value="/{id}/edit")
	public String edit(Model model, @PathVariable Integer id) {
		Person person = dao.get(id);
		model.addAttribute("person", person);
		return "people/edit";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(Person person) {
		person = dao.insert(person);
		return "redirect:/people";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable Integer id) {
		dao.deleteById(id);
		return "redirect:/people";
	}
}

















package com.theironyard.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.theironyard.models.Person;
import com.theironyard.services.PersonDao;

@Component
public class DataBootstrapper implements ApplicationListener<ContextRefreshedEvent>{
	private PersonDao dao;
	
	public DataBootstrapper(PersonDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		loadPeople();
	}
	
	public void loadPeople() {
		Person person = new Person();
		person.setId(1);
		person.setFirstName("Maria");
		person.setLastName("Gramajo");
		dao.insert(person);
		
		person = new Person();
		person.setId(2);
		person.setFirstName("Hamilton");
		person.setLastName("Gramajo");
		dao.insert(person);
	}
}
















package com.theironyard.services;

import java.util.List;

import com.theironyard.models.Person;

public interface PersonDao {
	List<Person> getPeople();
	
	Person insert(Person person);
	
	Person get(Integer id);

	void update(Person person);
}

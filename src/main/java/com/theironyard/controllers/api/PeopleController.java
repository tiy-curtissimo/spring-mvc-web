package com.theironyard.controllers.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.theironyard.models.Person;
import com.theironyard.services.PersonDao;

@Component("MikeIsAlwaysRight")
@Path("/people")
@Produces(MediaType.APPLICATION_JSON_VALUE)
public class PeopleController {
	private PersonDao dao;
	
	public PeopleController(PersonDao dao) {
		this.dao = dao;
	}
	
	@GET
	public List<Person> list() {
		return dao.getPeople();
	}
	
	@GET
	@Path("/{id}")
	public Person details(@PathParam("id") Integer id) {
		return dao.get(id);
	}
	
	@POST
	public Person create(@RequestBody Person person) {
		return dao.insert(person);
	}
}










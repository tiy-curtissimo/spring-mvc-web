package com.theironyard.controllers.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.theironyard.config.PATCH;
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
	public Response create(@RequestBody Person person) throws URISyntaxException {
		person = dao.insert(person);
		URI uri = new URI("/api/people/" + person.getId());
		return Response
				.created(uri)
				.type("application/json")
				.entity(person)
				.build();
	}
	
	@PUT
	@Path("/{id}")
	public Person replace(@PathParam("id") Integer id, @RequestBody Person person) {
		dao.update(person);
		return person;
	}
	
	@PATCH
	@Path("/{id}")
	public Person update(@PathParam("id") Integer id, @RequestBody PatchInstruction instruction) {
		Person person = dao.get(id);
		if (instruction.getOp().equals("replace") && instruction.getPath().equals("/firstName")) {
			System.out.println("Replacing first name");
			person.setFirstName(instruction.getValue());
		} else if (instruction.getOp().equals("replace") && instruction.getPath().equals("/lastName")) {
			System.out.println("Replacing last name");
			person.setLastName(instruction.getValue());
		}
		dao.update(person);
		return dao.get(id);
	}
	
	@DELETE
	@Path("/{id}")
	public Response remove(@PathParam("id") Integer id) {
		dao.deleteById(id);
		return Response.ok().build();
	}
}










package com.theironyard.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.theironyard.models.Person;
import com.theironyard.models.Product;
import com.theironyard.services.PersonDao;
import com.theironyard.services.ProductDao;

@Component
public class DataBootstrapper implements ApplicationListener<ContextRefreshedEvent>{
	private PersonDao peopleDao;
	private ProductDao productsDao;
	
	public DataBootstrapper(PersonDao peopleDao, ProductDao productsDao) {
		this.peopleDao = peopleDao;
		this.productsDao = productsDao;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		loadPeople();
		loadProducts();
	}
	
	public void loadProducts() {
		Product product = new Product();
		product.setName("Big Bag!");
		product.setDescription("Ever needed a big bag? Here's one.");
		product.setPrice(100.23);
		productsDao.insert(product);
		
		product = new Product();
		product.setName("Little Bag!");
		product.setDescription("Little bags for little hands.");
		product.setPrice(26.27);
		productsDao.insert(product);
		
		product = new Product();
		product.setName("Medium Bag");
		product.setDescription("It's a medium. It can tell the future!");
		product.setPrice(51.77);
		productsDao.insert(product);
	}
	
	public void loadPeople() {
		Person person = new Person();
		person.setFirstName("Iride");
		person.setMiddleInitial("A");
		person.setLastName("Gramajo");
		peopleDao.insert(person);
		
		person = new Person();
		person.setFirstName("Hamilton");
		person.setMiddleInitial("Q");
		person.setLastName("Gramajo");
		peopleDao.insert(person);
		
		person = new Person();
		person.setFirstName("Millicent");
		person.setMiddleInitial("X");
		person.setLastName("Skårsgaard");
		peopleDao.insert(person);
		
		person = new Person();
		person.setFirstName("Yusuke");
		person.setMiddleInitial("");
		person.setLastName("Narohito");
		peopleDao.insert(person);
	}
}
















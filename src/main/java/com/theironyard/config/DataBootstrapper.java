package com.theironyard.config;

import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.theironyard.models.Order;
import com.theironyard.models.Person;
import com.theironyard.models.Product;
import com.theironyard.services.OrderDao;
import com.theironyard.services.PersonDao;
import com.theironyard.services.ProductDao;

@Component
public class DataBootstrapper implements ApplicationListener<ContextRefreshedEvent>{
	private PersonDao personDao;
	private ProductDao productDao;
	private OrderDao orderDao;
	
	public DataBootstrapper(PersonDao personDao, ProductDao productDao, OrderDao orderDao) {
		this.personDao = personDao;
		this.productDao = productDao;
		this.orderDao = orderDao;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		loadPeople();
		loadProducts();
		loadOrders();
	}
	
	public void loadProducts() {
		Product product = new Product();
		product.setName("Big Bag!");
		product.setDescription("Ever needed a big bag? Here's one.");
		product.setPrice(100.23);
		productDao.insert(product);
		
		product = new Product();
		product.setName("Little Bag!");
		product.setDescription("Little bags for little hands.");
		product.setPrice(26.27);
		productDao.insert(product);
		
		product = new Product();
		product.setName("Medium Bag");
		product.setDescription("It's a medium. It can tell the future!");
		product.setPrice(51.77);
		productDao.insert(product);
	}
	
	public void loadPeople() {
		Person person = new Person();
		person.setFirstName("Iride");
		person.setMiddleInitial("A");
		person.setLastName("Gramajo");
		personDao.insert(person);
		
		person = new Person();
		person.setFirstName("Hamilton");
		person.setMiddleInitial("Q");
		person.setLastName("Gramajo");
		personDao.insert(person);
		
		person = new Person();
		person.setFirstName("Millicent");
		person.setMiddleInitial("X");
		person.setLastName("Skårsgaard");
		personDao.insert(person);
		
		person = new Person();
		person.setFirstName("Yusuke");
		person.setMiddleInitial("");
		person.setLastName("Narohito");
		personDao.insert(person);
	}
	
	public void loadOrders() {
		List<Person> people = personDao.getPeople();
		List<Product> products = productDao.getProducts();
		
		for (Person person : people) {
			for (Product product : products) {
				if ((person.getId() % 2) == 0 && (product.getId() % 2) == 0) {
					Order order = new Order();
					order.setCustomer(person);
					order.setProduct(product);
					order.setQuantity(person.getId() + product.getId());
					orderDao.insert(order);
				}
			}
		}
	}
}
















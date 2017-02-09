package com.theironyard.view.models;

import java.util.ArrayList;
import java.util.List;

import com.theironyard.models.Order;
import com.theironyard.models.Person;
import com.theironyard.models.Product;

public class PersonDto {
	private Person person;
	
	public PersonDto() {
		person = new Person();
	}
	
	public PersonDto(Person person) {
		this.person = person;
	}
	
	public Integer getId() {
		return person.getId();
	}
	public String getFirstName() {
		return person.getFirstName();
	}
	public String getLastName() {
		return person.getLastName();
	}
	public String getMiddleInitial() {
		return person.getMiddleInitial();
	}
	public List<PersonOrderDto> getOrders() {
		List<PersonOrderDto> orders = new ArrayList<PersonOrderDto>();
		for (Order order : person.getOrders()) {
			orders.add(new PersonOrderDto(order));
		}
		return orders;
	}
	
	public class PersonOrderDto {
		private Order order;
		
		public PersonOrderDto(Order order) {
			this.order = order;
		}
		
		public Integer getId() {
			return order.getId();
		}
		public Product getProduct() {
			return order.getProduct();
		}
		public Integer getQuantity() {
			return order.getQuantity();
		}
	}
}

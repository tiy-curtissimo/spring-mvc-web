package com.theironyard.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Service;

import com.theironyard.models.Order;
import com.theironyard.models.Person;
import com.theironyard.models.Product;

@Service
public class OrderDaoImpl implements OrderDao {
	private EntityManagerFactory factory;

	public OrderDaoImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public List<Order> getOrders() {
		EntityManager manager = factory.createEntityManager();
		
		return manager
				.createQuery("from Order", Order.class)
				.getResultList();
	}

	@Override
	public Order insert(Order order) {
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		order = manager.merge(order);
		manager.getTransaction().commit();
		
		return order;
	}

	@Override
	public Order get(Integer id) {
		EntityManager manager = factory.createEntityManager();
		return manager.find(Order.class, id);
	}

	@Override
	public void update(Order order) {
		insert(order);
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		Order order = manager.find(Order.class, id);
		manager.remove(order);
		manager.getTransaction().commit();
	}

	@Override
	public Order createOrder(Integer quantity, Integer customerId, Integer productId) {
		EntityManager manager = factory.createEntityManager();
		Order order = new Order();
		order.setQuantity(quantity);
		
		manager.getTransaction().begin();
		
		Person customer = manager.find(Person.class, customerId);
		Product product = manager.find(Product.class, productId);

		order.setCustomer(customer);
		order.setProduct(product);
		order = insert(order);
		manager.getTransaction().commit();
		return order;
	}
}

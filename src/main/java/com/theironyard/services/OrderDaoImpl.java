package com.theironyard.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Service;

import com.theironyard.models.Order;

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
}

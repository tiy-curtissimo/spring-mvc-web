package com.theironyard.services;

import java.util.List;

import com.theironyard.models.Order;

public interface OrderDao {
	List<Order> getOrders();
	
	Order insert(Order order);
	
	Order get(Integer id);

	void update(Order order);
	
	void deleteById(Integer id);
}

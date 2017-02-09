package com.theironyard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.theironyard.models.Order;
import com.theironyard.services.OrderDao;
import com.theironyard.services.PersonDao;
import com.theironyard.services.ProductDao;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	private PersonDao personDao;
	private OrderDao orderDao;
	private ProductDao productDao;
	
	public OrdersController(PersonDao personDao, OrderDao orderDao, ProductDao productDao) {
		this.personDao = personDao;
		this.orderDao = orderDao;
		this.productDao = productDao;
	}
	
	@RequestMapping("/new")
	public String newish(Model model) {
		model.addAttribute("products", productDao.getProducts());
		model.addAttribute("customers", personDao.getPeople());
		model.addAttribute("order", new Order());
		return "orders/new";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@RequestParam Integer quantity, @RequestParam Integer customerId, @RequestParam Integer productId) {
		orderDao.createOrder(quantity, customerId, productId);
		return "redirect:/";
	}
}

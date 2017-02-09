package com.theironyard.services;

import java.util.List;

import com.theironyard.models.Product;

public interface ProductDao {
	List<Product> getProducts();
	
	Product insert(Product product);
	
	Product getById(Integer id);

	void update(Product product);
	
	void deleteById(Integer id);
}

package com.kh.jdbc.controller;

import com.kh.jdbc.service.ProductService;
import com.kh.jdbc.service.OrderService;
import com.kh.jdbc.vo.Product;
import com.kh.jdbc.vo.Order;

import java.util.List;

public class Controller {

	private ProductService productService = new ProductService();
	private OrderService orderService = new OrderService();

	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	public List<String> getCategories() {
		return productService.getCategories();
	}

	public List<Product> getProductsByCategory(String category) {
		return productService.getProductsByCategory(category);
	}

	public Product getProductById(int productId) {
		return productService.getProductById(productId);
	}

	public boolean placeOrder(Order order) {
		return orderService.placeOrder(order);
	}

	public boolean updateStock(int productId, int qtyChange) {
		return productService.updateStock(productId, qtyChange);
	}
}

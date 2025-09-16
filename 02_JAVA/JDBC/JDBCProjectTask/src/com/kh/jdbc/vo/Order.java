package com.kh.jdbc.vo;

import java.util.List;

public class Order {
	private int orderId;
	private List<OrderItem> items;

	public Order(List<OrderItem> items) {
		this.items = items;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<OrderItem> getItems() {
		return items;
	}
}

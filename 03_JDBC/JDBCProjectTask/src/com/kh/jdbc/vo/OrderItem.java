package com.kh.jdbc.vo;

public class OrderItem {
	private int productId;
	private int quantity;
	private int price;

	public OrderItem(int productId, int quantity, int price) {
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}
}

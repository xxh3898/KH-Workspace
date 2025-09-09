package com.kh.jdbc.vo;

public class Product {
	private int productId;
	private String name;
	private String category;
	private int price;
	private int stock;
	private boolean soldOut;

	public Product(int productId, String name, String category, int price, int stock, boolean soldOut) {
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.soldOut = soldOut;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public boolean isSoldOut() {
		return soldOut;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setSoldOut(boolean soldOut) {
		this.soldOut = soldOut;
	}
}

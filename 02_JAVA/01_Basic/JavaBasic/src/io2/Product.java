package io2;

import java.io.Serializable;

public class Product implements Serializable {
	private String name;
	private int price;
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
}

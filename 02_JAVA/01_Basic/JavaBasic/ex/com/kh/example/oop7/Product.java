package com.kh.example.oop7;
//- **필드**
//- `pName : String` — 상품명
//- `price : int` — 가격
//- `brand : String` — 브랜드
//- **생성자**
//- `Product()` — 기본 생성자
//- `Product(String pName, int price, String brand)` — 필드 초기화 생성자
//- **메서드**
//- 각 필드별 **getter / setter** 직접 구현
//- `inform(): String`
//    
//    → `"상품명 : {상품명} / 가격 : {가격} / 브랜드 : {브랜드}"` 형태의 문자열 반환
public class Product {
	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	private String pName;
	private int price;
	private String brand;
	
	public Product() {
		super();
	}
	
	public Product(String pName, int price, String brand) {
		this.pName = pName;
        this.price = price;
        this.brand = brand;
	}
	
	public String inform() {
		return "상품명 : "+pName+" / 가격 : "+price+" / 브랜드 : "+brand;
	}
}

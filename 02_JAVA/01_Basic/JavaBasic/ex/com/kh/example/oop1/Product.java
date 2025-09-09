package com.kh.example.oop1;

public class Product {
    // 필드 선언
    public String pName;
    public int price;
    public String brand;

    // 기본 생성자
    public Product() {
    	super();
    }

    // 정보 출력 메서드
    public void information() {
        System.out.println("상품명 : " + pName);
        System.out.println("가격 : " + price + "원");
        System.out.println("브랜드 : " + brand);
    }
}

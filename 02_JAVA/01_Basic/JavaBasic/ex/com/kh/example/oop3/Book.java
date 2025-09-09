package com.kh.example.oop3;

public class Book {
    private String title;
    private String publisher;
    private String author;
    private int price;
    private double discountRate;

    // 기본 생성자
    public Book() {
        this.title = "제목 없음";
        this.publisher = "출판사 없음";
        this.author = "저자 없음";
        this.price = 0;
        this.discountRate = 0.0;
    }

    // 매개변수 생성자
    public Book(String title, String publisher, String author) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.price = 0;
        this.discountRate = 0.0;
    }

    // 정보 출력 메서드
    public void inform() {
        System.out.println("제목: " + title);
        System.out.println("출판사: " + publisher);
        System.out.println("저자: " + author);
        System.out.println("가격: " + price + "원");
        System.out.println("할인율: " + discountRate + "%");
    }

    // Getter/Setter (필요 시 사용)
    // ... 생략 가능
}

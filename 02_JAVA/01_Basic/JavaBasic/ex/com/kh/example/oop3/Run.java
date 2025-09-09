package com.kh.example.oop3;

public class Run {

    public static void main(String[] args) {
        Book b1 = new Book();      // 기본 생성자 사용
        b1.inform();

        System.out.println();

        Book b2 = new Book("신나는 자바", "KH", "최지원");  // 매개변수 생성자 사용
        b2.inform();  // ✅ 오타 수정: inform()
    }
}

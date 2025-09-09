package com.kh.example.oop1;

public class Run {

    public static void main(String[] args) {
        Product pro = new Product();    // 기본 생성자 호출
        pro.setpName("사과");
        pro.setPrice(1000);
        pro.information();              // 정보 출력
    }

}

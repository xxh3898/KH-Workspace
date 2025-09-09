package com.kh.interface01;

public class Cat implements Animal{

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("야옹");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("고양이가 걷습니다.");
	}
	
}
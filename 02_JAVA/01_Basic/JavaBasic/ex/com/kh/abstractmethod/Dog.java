package com.kh.abstractmethod;

public class Dog implements Animal{

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("멍멍");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("강아지가 달립니다.");
	}
	
}
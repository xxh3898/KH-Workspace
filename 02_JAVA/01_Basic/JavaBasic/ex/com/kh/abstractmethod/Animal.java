package com.kh.abstractmethod;

public abstract class Animal{
	//일반메서드
	public void breath() {
		System.out.println("숨을 쉽니다.");
	}
	
	public abstract void speak();
	public abstract void move();
}
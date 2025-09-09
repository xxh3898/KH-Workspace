package com.kh.option;

public class Counter {
	static int count=0;
	
	String name;

	public Counter(String name) {
		this.name = name;
		count++;
	}
	
	public static void showCount() {
		System.out.println("현재 생성된 객체 수 : "+count);
	}
}

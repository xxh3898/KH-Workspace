package com.kh.basic;

public class Output {

	public static void main(String[] args) {
		// 코드를 사용하는 영역
		
		// 출력문
		// print() -> 일반적인 출력문으로 ()안에 있는 값을 화면에 출력함
		System.out.print("안녕하세요.");
		System.out.print("안녕하세요.\n");
		
		// println() -> 개행문자를 포함한 출력문
		System.out.println("안녕하세요. 조치호입니다.");
		System.out.println("안녕하세요. 조치호입니다.");
		
		// 문자열 포맷을 이용한 출력물
		// System.out.printf(문자열포맷, 값1, 값2, 값3, ...)
		String name = "조치호";
		int age=25;
		System.out.println("저는 "+ name+ "이고 나이는 "+age+"살 입니다.");
		System.out.printf("저는 %s이고 나이는 %d살 입니다.", name, age);
		/*
		 * 포맷 안에서 쓸 수 있는 키워드
		 * %d : 정수
		 * %c : 문자(char 한글자)
		 * %s : 문자열
		 * %f : 실수
		 * */
	}

}

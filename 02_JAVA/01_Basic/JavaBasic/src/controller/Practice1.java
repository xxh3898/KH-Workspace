package controller;

import java.util.Scanner;

public class Practice1 {
	/*
	 * 나이를 입력받아
	 * 13세 이하 : 어린이
	 * 13세 초과 19세이하 : 청소년
	 * 19세 초과 : 성인
	 * 
	 * [출력]
	 * 나이를 입력 : XX
	 * XX은 XXX에 속합니다.
	 * */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int age;
		String grade="성인";
		
		System.out.println("나이를 입력 : ");
		age=sc.nextInt();
		if(age<=13) {
			grade="어린이";
		} else if(age<=19) {
			grade="청소년";
		}
		System.out.printf("%d는 %s에 속합니다.\n", age, grade);


	}

}

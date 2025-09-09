package controller;

import java.util.Scanner;

public class Practice2 {
	/*
	 *성별을(m/f)(대소문자 상관X)로 입력받아 남학생인지 여학생인지 출력 
	 **/
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		char gender;
		
		System.out.println("성별을 입력하시오.(m/f) : ");
		// 문자열 입력.대문자로 모두 변경.맨앞글자추출
		gender=sc.next().toUpperCase().charAt(0);
		// toUpperCase() : 모든 문자열을 대문자로 변환
		// tolowerCase() : 모든 문자열을 소문자로 변환	
		
		if(gender=='f' || gender=='F') {
			System.out.println("여학생입니다.");
		}else if(gender=='m' || gender=='M') {
			System.out.println("남학생입니다.");
		}else {
			System.out.println("잘못입력하셨습니다.");
		}
	}
}

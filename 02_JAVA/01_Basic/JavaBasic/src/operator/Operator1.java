package operator;

import java.util.Scanner;

public class Operator1 {
	/*
	 * 1. 논리부정 연산자
	 * 논리값(True/False)을 반대로 변경하는 연산자
	 * */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("True의 부정 : "+ !(true));
		System.out.println("False의 부정 : "+ !(false));
		
		System.out.println("값1 : ");
		int num1=sc.nextInt();
		
		System.out.println("값2 : ");
		int num2=sc.nextInt();
		
		System.out.println("값1>값2 : "+(num1>num2));
	}

}

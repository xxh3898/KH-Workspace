package operator;

import java.util.Scanner;

public class Practice2 {
	/*
	 * 키보드로 정수 두 개를 입력받아 두 수의 합, 차, 곱, 나누기, 나머지 값을 출력
	 * 
	 * [출력]
	 * 첫번쨰 정수 : (키보드 입력)
	 * 두번쨰 정수 : (키보드 입력)
	 * 
	 * 더하기 : n
	 * 빼기 : n
	 * 곱하기 : n
	 * 나누기 : n
	 * 나머지 : n
	 * */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int num1, num2;
		
		System.out.println("첫번째 정수 : ");
		num1=sc.nextInt();
		
		System.out.println("두번째 정수 : ");
		num2=sc.nextInt();
		
		System.out.println("더하기 : "+(num1+num2));
		System.out.println("뺴기 : "+(num1-num2));
		System.out.println("곱하기 : "+(num1*num2));
		System.out.println("나누기 : "+(num1/num2));
		System.out.println("나머지 : "+(num1%num2));
		
		sc.close();
	}

}

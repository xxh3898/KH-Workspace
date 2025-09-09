package com.kh.example.exception2;
import java.util.Scanner;
public class NumberMenu {
	public void menu() {
		Scanner sc=new Scanner(System.in);
		System.out.println("정수 1: ");
		int num1=sc.nextInt();
		System.out.println("정수 2: ");
		int num2=sc.nextInt();
		
		NumberController nc=new NumberController();
		
		try {
			boolean isCheck = nc.checkDouble(num1, num2);
			
			System.out.printf("%d은(는) %d의 배수인가 ? %d",num1, num2, isCheck);
		}catch(NumRangeException e){
			System.out.println("1부터 100 사이의 값이 아닙니다.");
		}
	}
}

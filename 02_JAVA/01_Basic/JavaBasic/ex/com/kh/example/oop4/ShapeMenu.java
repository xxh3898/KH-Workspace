package com.kh.example.oop4;

import java.util.Scanner;

public class ShapeMenu {
	private Scanner sc=new Scanner(System.in);
	private SquareController scr=new SquareController();
	private TriangleController tc=new TriangleController();
	
	public void inputMenu() {
		System.out.println("===== 도형 프로그램 =====");
		System.out.println("3. 삼각형");
		System.out.println("4. 사각형");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴번호 : ");
		
		int select=sc.nextInt();
		sc.nextLine();
		
		switch(select) {
		case 3:
			triangleMenu();
			break;
		case 4:
			squareMenu();
			break;
		case 9:
			System.out.println("프로그램 종료");
			return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
	}
	
	public void triangleMenu() {
		System.out.println("===== 삼각형 =====");
		System.out.println("1. 삼각형 면적");
		System.out.println("2. 삼각형 색칠");
		System.out.println("3. 삼각형 정보");
		System.out.println("9. 메인으로");
		System.out.println("메뉴 번호 : ");
		
		int select=sc.nextInt();
		sc.nextLine();
	}
	
	public void squareMenu() {
		System.out.println("===== 사각형 =====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 면적");
		System.out.println("3. 사각형 색칠");
		System.out.println("4. 삼각형 정보");
		System.out.println("9. 메인으로");
		System.out.println("메뉴 번호 : 1");
		
		int select=sc.nextInt();
		sc.nextLine();
	}
	
	public void inputSize(int type, int menuNum) {
		switch(menuNum) {
		case 1:{
			System.out.println("높이 : ");
			double height=sc.nextDouble();
			System.out.println("너비 : ");
			double width=sc.nextDouble();
			
			double perimeter=scr.calcArea(height, width);
			System.out.println("사각형의 둘레 : "+perimeter);
		}break;
		case 2:{
			System.out.println("높이 : ");
			double height=sc.nextDouble();
			System.out.println("너비 : ");
			double width=sc.nextDouble();
			
			double area;
			if(type==3){
				scr.calcArea(height, width);
			}else{tc.calcArea(height, width);
			}
		
		}break;
		case 3:{
			System.out.println("색깔을 입력하세요 : ");
			String color=sc.next();
			sc.nextLine();
			
			if(type==3) {
				tc.paintColor(color);
				}else{
					scr.paintColor(color);}
			}
		}
		
		}
	public void printInformation(int type) {
		System.out.println();
	}
		}


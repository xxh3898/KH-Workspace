package com.kh.example.oop7;

import java.util.Scanner;

import review6.PersonController;
import review6.Student;

public class PersonMenu {
	PersonController pc = new PersonController();
	Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		// while(true) {
		System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
		System.out.println("현재 저장된 학생은 " + pc.personCount()[0] + "명입니다.");
		System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
		System.out.println("현재 저장된 사원은" + pc.personCount()[1] + "명입니다.");
		System.out.println("1. 학생 메뉴");
		System.out.println("2. 사원 메뉴");
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");
		int sel = sc.nextInt();
		sc.nextLine();

		switch (sel) {
		case 1: {
			studentMenu();
			break;
		}
		case 2: {
			break;
		}
		case 9: {
			System.out.println("프로그램 종료");
			return;
		}
		default: {
			System.out.println("다시 입력해주세요");
			break;
		}
		}

	}

	public void studentMenu() {
		while(true) {
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 보기");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int sel = sc.nextInt();
		sc.nextLine();

		switch (sel) {
		case 1: {
			String name = sc.nextLine();
			int age = sc.nextInt();
			sc.nextLine();
			double height = sc.nextDouble();
			sc.nextLine();
			double weight = sc.nextDouble();
			sc.nextLine();
			int grade = sc.nextInt();
			sc.nextLine();
			String major = sc.nextLine();
			pc.insertStudent(name, age, height, weight, grade, major);
			break;
		}
		case 2: {
			Student[] students = pc.printStudent();
			for (Student s : students) {
			    if (s != null) {
			        System.out.println(s);  // toString() 호출됨
			    }
			}

			break;
		}
		case 9: {
			return;
		}
		default: {
			System.out.println("다시 입력해주세요");
			break;
		}
		}
	}

	}

	public void employeeMenu() {

	}



}
//}

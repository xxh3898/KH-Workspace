package com.kh.example.exception1;

import java.util.Scanner;

public class CharacterMenu {
	public void menu() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("문자열 : ");
		String str=sc.nextLine();

		CharacterController cc=new CharacterController();
		
		try {
			int count=cc.countAlpha(str);
			System.out.printf("%s에 포함된 영문자 개수 : %d\n",str, count);
		} catch(CharCheckException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
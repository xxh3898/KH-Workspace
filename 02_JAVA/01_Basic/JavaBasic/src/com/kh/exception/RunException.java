package com.kh.exception;

import java.io.BufferedReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunException {
	public void method1() {
		Scanner sc= new Scanner(System.in);
	
		try {
		System.out.println("a/b..a: ");
		int a=sc.nextInt();
		System.out.println("a/b..b: ");
		int b=sc.nextInt();
		
		System.out.printf("%d / %d = %d\n",a,b,a/b);
		System.out.println("계산 완료");
	}catch(ArithmeticException e) {
		System.out.println("수학적 에러 발생"+e.getMessage());
	}catch(InputMismatchException e) {
		System.out.println("입력오류 발생");
		e.printStackTrace();
	}
		
		//2. throws: 여기서 예외를 처리하지 않고 현재 이 메서드를 호출한 곳으로 예외처리를 위임한다.
		public void method2() {
			//CheckedException : 반드시 예외처리를 해야하는 예외들(강제되어 안 할 수 없음)
			//-> 조건문을 미리 제시할 수 없음(왜? 예측이 불가한 경우가 많음)
			//-> 외부 매게체와 입출력이 일어날 때 발생할 수 있음
			
			//Scanner와 같이 키보트로 입력받은 값을 코드로 가져와주는 객체(단, 문자열로만 읽어ㄷ드린다.)
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			
			String str=null;
			str=br.readLine();
			System.out.println(str);
		}
	}
}

package loop;

import java.util.Scanner;

public class For {
	/*
	 * <반복문>
	 * 특정 코드를 여러 번 반복해서 실행하고자 할 때 사용하는 제어문
	 * 
	 * 대표적으로 for, while, do-while이 있다.
	 * 
	 * for문
	 * 반복횟수가 명확할 때 가장 많이 사용됨
	 * 
	 * for(초기식; 조건식; 증감식;){
	 * 	반복 실행 할 코드
	 * 	}
	 * 
	 * 초기식 : 반복을 시작하기 전 변수를 선언하고 초기값을 설정, 처음 딱 한 번만 실행
	 * 조건식 : 반복을 계속 진행할지 여부를 판단하는 조건, 조건이 true면 반복진행, false면 반복종료 매번 반복문의 코드를 실행하기 전에 확인 보통 초기식에서 제시된 변수를 활용하여 조건식을 정함
	 * 증감식 : 매번 반복이 끝난 후 변수 값을 증가/감소시키는 부분
	 * 		  보통 초기식에서 제시된 변수를 가지고 증감을 처리함
	 * */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<5;i++) {
			System.out.println("안녕하세요".charAt(i));
		}
		System.out.println("");
		/*
		 * n번반복
		 * for(int i=0; i<n; i++){
		 * 	반복할 코드
		 * }
		 * */
		for(int i=11;i<=17;i+=2) {
			System.out.println(i);
		}
		System.out.println("");

		// 1~5까지의 숫자를 순차적으로 출력하세요
		for(int i=1;i<6;i++) {
			System.out.print(i+" ");
		}
		System.out.println("");
		/*
		 * 자바의 지역변수(블록 scope)
		 * - 특정 메서드나 블록({}) 내부에서 선언하고
		 * 	  선언된 블록 범위 내에서만 접근이 가능하다.
		 * - 해당 블록이 종료되면 블로내부의 변수도 함께 사라진다.
		 * */
		for(int i=6;i>0;i--) {
			int num=10;
			System.out.println(10-i);
		}
		// 정수n을 입력받아 1부터 n까지 1씩 증가시키면서 출력하라
		// 정수 입력 : n
		// 1 2 3 4...n
		
		System.out.println("정수 입력 : ");
		int num=sc.nextInt();
		sc.nextLine();
		for(int i=1;i<=num;i++) {
			System.out.print(i+" ");
		}
		/*
		 * 커피주문 키오스크
		 * 
		 * [출력]
		 * 아메리카노를 몇 잔 주문하시겠습니까?(1100원) : n
		 * 결제하실 금액은 XXX원 입니다.
		 * */
		System.out.println("아메리카노를 몇 잔 주문하시겠습니까(1100) : ");
		int count=sc.nextInt();
		int price=0;
		sc.nextLine();
		for(int i=0;i<count;i++) {
			price+=1100;
		}
		System.out.printf("결제하실 금액은 %d원 입니다.",price);
		System.out.println("");

		// 1~10 숫자 중 홀수만 출력(조건처리)
		// 1 3 5 7 9
		for(int i=1;i<=10;i++) {
			if(i%2==1) {
				System.out.print(i+" ");
			}
		}
		// 1~100까지의 수 중 짝수의 합을 구해라
		// 1~100까지의 짝수 합 : XXX
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%2==0) {
				sum+=i;
			}
		}
		System.out.println("1~100까지의 짝수 합 : "+sum);
		System.out.println("");
		
		System.out.println(Math.random());
		/*
		 * Math.random()
		 * java.lang.Math 클래스에서 기본적으로 제공하는 함수로 호출하면 매번 다른 랜덤값을 반환한다
		 * 
		 * Math.random() 호출시 -> 0.0~0.999999999 사이의 랜덤값을 반환
		 * int num=(int)Math.random() ->0~0
		 * int num=(int)(Math.random()*10)+1; -> 1~10;
		 * 최소값~최대값 랜덤 수 : (int)(Math.random()*(최대값 +1 - 최소값))+최소값;
		 * */
		
		// random(1~10)한 숫자 n을 생성해서 1부터 n까지 모두 더한 값을 출력하라
		int n=(int)(Math.random()*10)+1;
		int result=0;
		for(int i=1; i<=n;i++) {
			result+=i;
		}
		System.out.println("랜덤수 : "+n);
		System.out.printf("1~%d까지의 합 : %d\n",n,result);
		System.out.println("");
		
		/*
		 * 각 인덱스별 문자 출력 : Hello
		 * str.chatAt(0) -> H
		 * str.chatAt(1) -> e
		 * str.chatAt(2) -> l
		 * str.chatAt(3) -> l
		 * str.chatAt(4) -> o
		 * index반복 -> 0~(길이-1)
		 * */
		System.out.println("문자열 출력 : ");
		String str=sc.next();
		System.out.println("문자열의 길이 : "+str.length());
		for(int i=0;i<str.length();i++) {
			System.out.print(str.charAt(i)+" ");
		}
		System.out.println("");
		// 사용자에게 문자열을 입력받아 해당 문자열의 짝수자리 글자만 출력
		// 문자역 입력 : Hello
		// el
		
		System.out.println("문자열 입력 : ");
		String str2=sc.next();
		for(int i=0;i<str2.length();i++) {
			if(i%2==1) {
			System.out.print(str2.charAt(i)+" ");
			}
		}
		
		for(int i=1;i<=9;i++) {
			System.out.printf("%d * %d = %d\n",2,i,(2*i));
		
		}
	}

}


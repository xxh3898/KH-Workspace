package loop;

import java.util.Scanner;

public class While {
	/*
	 * while문
	 * 
	 * [포현법]
	 * 
	 * while(조건식){
	 * 		반복할 코드
	 * 		[탈출이 가능한 구조]
	 * 	}
	 * */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<10;i++) {
			System.out.println("안녕하세요");
		}
		
		int i=0; // 조건식에 사용할 값을 선언
		while(i<10) {
			System.out.println("안녕하세요");
			i++; // 조건에 영향을 주는 증감
		}
		for(int n=sc.nextInt(); n!=0;n=sc.nextInt()) {
			System.out.println(n);
		}
		
		int n=sc.nextInt();
		while(n!=0) {
			System.out.println(n);
			n=sc.nextInt();
		}
		int random=(int)(Math.random()*100)+1;
		int sum=0;
		for(int k=1;k<=random;k++) {
			sum+=k;
		}
		// 사용자가 0을 입력할 때까지 랜던값 1~100을 하나씩 생성해서 모두 더한 값을 출력하라
		
		int choice=sc.nextInt();
		int sum2=0;
		while(choice!=0) {
			int random2=(int)(Math.random()*100)+1;
			sum2=+random2;
			choice=sc.nextInt();
		}
		System.out.println("지금까지의 총 합 : "+sum2);
		
		int num;
		
		System.out.println("서비스 번호를 입력하세요.");
		System.out.println("1. 추가");
		System.out.println("2. 삭제");
		System.out.println("3. 종료");
		
		System.out.println("입력 : ");
		num=sc.nextInt();
		while(num!=3) {
			switch(num) {
			case 1:
				// 추가하는 로직
				System.out.println("추가되었습니다.");
				break;
			case 2:
				// 삭제하는 로직
				System.out.println("삭제되었습니다.");
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
			}
			System.out.println("입력 : ");
			num=sc.nextInt();
		}
}

}

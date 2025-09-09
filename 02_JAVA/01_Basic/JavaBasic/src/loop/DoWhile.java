package loop;

import java.util.Scanner;

/*
	 * do-while문
	 * 
	 * do{
	 * 		실행할 코드
	 * } while(조건식);
	 * 
	 * 처음에 무조건 실행코드 한 번 실행되고 조건문을 검사
	 * 
	 * *기존의 for/while문은 처음 수행될 때 조건검사 후 true일 경우에만 반복코드를 실행함
	 * 하지만 do-while은 첫 실행은 조건검사를 하지 않고 무조건 실행
	 * */
public class DoWhile {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// 사용자가 입력한 수를 계속해서 더하는 프로그램 작성
		// 단, 사용자가 0을 입력하면 종료
		int sum=0;
		int num;
		do {
			num=sc.nextInt();
			sum+=num;
		}while(num!=0); 
	}

}

package loop;

import java.util.Scanner;

public class Practice03 {
/*
 * 테스트 케이스(`T`)만큼 **두 정수 `A`와 `B`를 입력받아, 각각의 합을 출력**하는 프로그램을 작성하세요.

	단, 출력 형식은 `"Case #x: "` 뒤에 합을 붙여 출력해야 하며, `x`는 1부터 시작하는 **테스트 케이스 번호**입니다.
 * */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int count=sc.nextInt();
		for(int i=1;i<=count;i++) {
			int num1=sc.nextInt();
			int num2=sc.nextInt();
			System.out.printf("case #%d: %d\n",i,(num1+num2));
		}
	}

}

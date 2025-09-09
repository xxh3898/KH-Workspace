package loop;

import java.util.Scanner;

public class Practice2_3 {
// 사용자로부터 10개의 정수를 입력받아, **짝수일 경우에만 제곱을 출력**하는 프로그램을 작성하세요. 홀수는 건너뛰고 출력하지 않습니다.
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<10;i++) {
			System.out.println("숫자 입력 : ");
			int num=sc.nextInt();
			if(num%2!=0) {
				continue;
			}
			System.out.printf("짝수 %d의 제곱은 %d입니다\n", num, num*num);
		}
	}

}

package loop;

import java.util.Scanner;

// 사용자로부터 정수 N(1 ≤ N ≤ 20)을 입력받아, N층의 왼쪽 정렬된 별 피라미드를 출력하세요.
public class Practice2_5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int n=sc.nextInt();
		if(n>=1&&n<=20) {
			for(int i=1;i<=n;i++) {
				for(int k=1;k<=i;k++) {
					System.out.print("*");
				}
				System.out.println("");
			}
		}else {
			System.out.println("오류");
		}
	}

}
